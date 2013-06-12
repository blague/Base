package org.zj.elong;

import com.google.common.io.Files;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Read {

    static {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);
    }
    private static JdbcTemplate jdbcTemplate;

    public static final String URL_FORMAT = "http://hotel.elong.com/hotcity/hotel/%d.html?callback=";
    //
    public static final String URL_POI = "http://hotel.elong.com/isajax/HotelIndex/GetPoiCity?_=1371022342272&cityId=%1$s&cityCode=%2$s&viewpath=~%%2Fviews%%2FHotelIndex%%2FNewIndex.aspx&language=cn&issquare=False";

    public static final String URL_LOCATION = "http://api.map.baidu.com/geocoder/v2/?ak=B5bf8c907cf0cdda46371e6a2ef67696&callback=renderOption&output=json&address=%1$s&city=%2$s";

    public static final String INSERT_CITY = "insert into city values(?,?,?)";

    public static final String INSERT_TYPE ="insert into poi_type(id,name) values (?,?)";

    public static final String INSERT_TAG ="insert into poi_tag(id,name,cityid,typeid) values (?,?,?,?)";

    public static final String INSERT_POI ="insert into poi_detail(id,name,cityid,typeid,tagid) values (?,?,?,?,?)";

    public static final String QUERY_POI = "SELECT d.name,c.name,d.cityid,d.typeid,d.tagid,d.id FROM POI_DETAIL d left join CITY c  on d.CITYID =c.ID order by d.cityid,d.typeid,d.tagid,d.id";

    public static final String QUEYY_CITY = "select * from city order by id";



    public static void main(String[] args) throws IOException {
        Read read = new Read();
        read.getLocation();
//        jdbcTemplate.execute("delete from poi_type");
//        jdbcTemplate.execute("delete from poi_tag");
//        jdbcTemplate.execute("delete from poi_detail");
//        jdbcTemplate.execute("drop index if exists  PRIMARY_KEY_AA");
    }


    public void getLocation() throws IOException {
        List<String[]> list = jdbcTemplate.query(QUERY_POI,new RowMapper<String[]>() {
            @Override
            public String[] mapRow(ResultSet rs, int i) throws SQLException {
                return new String[]{rs.getString(1),rs.getString(2)};
            }
        });
        BufferedWriter bufferedWriter = null;
        int idx = 0;
        try{
            bufferedWriter = Files.newWriter(new File("D:/hotel_poi_location.data"), Charset.defaultCharset());
            for (int i =1280,length = list.size() ; i< length ; i++){
                String[] poi = list.get(i);
                String url = String.format(URL_LOCATION,new String[]{poi[0],poi[1]});
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                idx = i;
                bufferedWriter.write(poi[1]+" - "+poi[0]+" - "+doc.body().text());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            System.out.println(idx);
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void insertPOI(){
        int  i = 0;
        try {
            List<String> list = Files.readLines(new File("D:/hotel_poi.data"), Charset.defaultCharset());
            final Map<String,String[]> typeMap = new HashMap<String, String[]>();//type
            final List<String[]> tagList = new ArrayList<String[]>();
            final List<String[]> detialList = new ArrayList<String[]>();
            for (String jsonData : list){
                final JSONObject reuslt = JSONObject.fromObject(jsonData);
                final String cityid = JSONObject.fromObject(reuslt.get("value")).getString("CityId");
                JSONObject pois = JSONObject.fromObject(JSONObject.fromObject(reuslt.get("value")).get("PoiTypeList"));
                Iterator poisIterator = pois.entrySet().iterator();
                while (poisIterator.hasNext()){
                    JSONObject poiType = JSONObject.fromObject(JSONObject.fromObject(poisIterator.next()).get("value"));
                    final String poiTypeName = poiType.getString("PoiTypeName");
                    final String poiTypeId = poiType.getString("PoiTypeId");
                    if(!typeMap.containsKey(poiTypeId)){
                       typeMap.put(poiTypeId,new String[]{poiTypeId,poiTypeName});
                        jdbcTemplate.update(INSERT_TYPE,new PreparedStatementSetter() {
                            @Override
                            public void setValues(PreparedStatement ps) throws SQLException {
                                ps.setString(1,poiTypeId);
                                ps.setString(2, poiTypeName);
                            }
                        });
                    }
                    Iterator poiTagIterator = JSONObject.fromObject(poiType.get("PoiTagList")).entrySet().iterator();
                    while(poiTagIterator.hasNext()){
                        JSONObject poiTag = JSONObject.fromObject(JSONObject.fromObject(poiTagIterator.next()).get("value"));
                        final String poiTagName = poiTag.getString("PoiTagName");
                        final String poiTagId = poiTag.getString("PoiTagId");
                        tagList.add(new String[]{poiTagId,poiTagName,cityid,poiTypeId});
                        Object[] poiDetails = JSONArray.fromObject(poiTag.get("PoiDetailList")).toArray();
                        for (Object detail : poiDetails){
                            final JSONObject poi = JSONObject.fromObject(detail);
                            detialList.add(new String[]{poi.getString("PoiId"),poi.getString("PoiName"),cityid,poiTypeId,poiTagId});
                             i++;
                        }
                    }
                }
            }
            jdbcTemplate.batchUpdate(INSERT_TAG,new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,tagList.get(i)[0]);
                    ps.setString(2,tagList.get(i)[1]);
                    ps.setString(3,tagList.get(i)[2]);
                    ps.setString(4,tagList.get(i)[3]);
                }
                @Override
                public int getBatchSize() {
                    return tagList.size();
                }
            });
            System.out.println("插入tag完成");
            jdbcTemplate.batchUpdate(INSERT_POI,new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,detialList.get(i)[0]);
                    ps.setString(2,detialList.get(i)[1]);
                    ps.setString(3,detialList.get(i)[2]);
                    ps.setString(4,detialList.get(i)[3]);
                    ps.setString(5,detialList.get(i)[4]);
                }
                @Override
                public int getBatchSize() {
                    return detialList.size();
                }
            });
            System.out.println("插入poi完成");
            System.out.println(typeMap.size());
            System.out.println(tagList.size());
            System.out.println(detialList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo() {
        List<City> cityList =  jdbcTemplate.query(QUEYY_CITY, new RowMapper<City>() {
            public City mapRow(ResultSet rs, int i) throws SQLException {
                return new City(rs.getString(1),rs.getString(2),rs.getString(3));
            }
        });
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = Files.newWriter(new File("D:/hotel_poi.data"), Charset.defaultCharset());
            for (City city : cityList){
                String url = String.format(URL_POI,new String[]{city.getId(),city.getEname()});
                System.out.println(city.getId()+" - "+city.getEname()+" - " +city.getName());
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                bufferedWriter.write(doc.body().text());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 返回读取的城市信息.
     */
    public JSONArray readCity() throws IOException{
        JSONArray cities = new JSONArray();
        for (int i = 1;i<=6;i++){
            String url = String.format(URL_FORMAT,i);
            Document doc = Jsoup.connect(url).execute().parse();
            String js = doc.body().text().substring(1).split("\\)")[0];
            cities.addAll(JSONArray.fromObject(JSONObject.fromObject(js).get("CityList")));
        }
        return cities;
    }

    /**
     * 插入城市数据
     */
    public void insertCity(JSONArray array){
        for (Object ob : array.toArray()){
            final JSONObject city = JSONObject.fromObject(ob);
            try{
                jdbcTemplate.update(INSERT_CITY,new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1,city.getString("CityCode"));
                        ps.setString(2,city.getString("CityNameCn"));
                        ps.setString(3,city.getString("CityNameEn"));
                    }
                });
            }catch (Exception e){
                System.out.println(city.getString("CityNameCn")+" - "+city.getString("CityCode")+"  -  "+e.getMessage());
            }

        }

    }
}
