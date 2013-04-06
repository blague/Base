package org.zj.poi;

import com.google.common.base.Strings;
import  org.jsoup.nodes.Document;
import  org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.util.StringUtils;
import org.zj.pojo.Area;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadWord {


    /**
     * 查询地区表中是否存在该地区.
     */
    public static final String QUERY_COUNT_AREA = "select count(*) from AREA where name = ?";
    /**
     * 插入地区数据
     */
    public static final String INSERT_AREA = "insert into area values (null,?,?)";
    /**
     * 查询对应的三字码的国家,洲
     */
    public static final String QUERY_COUNTY_AREA  = "select id,name,parent from Area where  name  = ?";

    /**
     * 根据三字码修改对应城市所在洲,国家
     */
    public static final String UPDATE_AIRPORTCODE_COUNTY = "UPDATE AIRPORTCODE SET  COUNTY = ? ,CONTINENT = ? WHERE THREECODE  = ?";




    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);


        Map<String,String> urlMap = new HashMap<String, String>();
        urlMap.put("1","http://www.51ticket.net/ziliao/yazhou.htm");
        urlMap.put("2","http://www.51ticket.net/ziliao/ouzhou.htm");
        urlMap.put("3","http://www.51ticket.net/ziliao/nammei.htm");
        urlMap.put("3","http://www.51ticket.net/ziliao/beimei.htm");
        urlMap.put("4","http://www.51ticket.net/ziliao/feizhou.htm");
        urlMap.put("5","http://www.51ticket.net/ziliao/aozhou1.htm");

        try {
            Map<String,Area> areaMap = new HashMap<String, Area>();
            Iterator<Map.Entry<String,String>> iterator =urlMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, String> enty =iterator.next();
                Document doc = Jsoup.connect(enty.getValue()).get();
                Elements element = doc.select("#table1 tr");
                for (int i = 1,length = element.size(); i < length; i++) {
                    final String name = element.get(i).child(1).text();
                    //TODO 将所有国家的机场三字码全部抓取,放置到areMap中.2013年4月6日 22:19:45


                }
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
