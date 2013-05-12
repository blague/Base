package org.zj.citycontrol.index;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.*;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zj.citycontrol.dao.AreaDao;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Index {

    public static final String INDEX_PATH = "area-indexs";

    @Autowired
    private AreaDao areaDao;

    public void create() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        areaDao  = appContext.getBean("areaDao", AreaDao.class);
        IndexWriter indexWiter = null;
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
        try {
            File file = new File(INDEX_PATH);

            Directory directory = FSDirectory.open(file);
            IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_36, analyzer);
            indexWiter = new IndexWriter(directory, writerConfig);

            List<Map<String, Object>> areaList = areaDao.getAllArea(false);

            for (Map<String, Object> area : areaList) {
                Document doc = new Document();
                Iterator iter = area.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    doc.add(new Field(entry.getKey().toString(), entry.getValue().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                }
                indexWiter.addDocument(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(indexWiter!=null)
                try {
                    indexWiter.close();
                } catch (CorruptIndexException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


    public TopDocs search(String fieldName,String str) {
        IndexReader reader = null;
        try{
            //1.创建Directory：去哪里搜索
            Directory directory=FSDirectory.open(new File(INDEX_PATH));

            //2.创建IndexReader
            reader=IndexReader.open(directory);
            //3.根据IndexReader创建IndexSearcher
            IndexSearcher searcher=new IndexSearcher(reader);

            //4.创建搜索的Query
            //创建parser来确定要搜索文件的内容，第二个参数表示搜索的域
            QueryParser parser= null;
            //创建Query，表示搜索域为content中包含java的文档
            Query query=parser.parse(str);
            return searcher.search(query,2);
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
          Index index = new Index();
        TopDocs tds = index.search("MC","*");
        if (tds != null) {
            System.out.println(tds.totalHits);
        }

    }


}
