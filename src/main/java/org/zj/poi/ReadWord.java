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
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.util.StringUtils;
import org.zj.pojo.Area;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public static final String UPDATE_AIRPORTCODE_COUNTY = "UPDATE AIRPORTCODE SET  COUNTY = ? ,CONTINENT = ? WHERE THREECODE  in ?";




    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);


        List<String> urls = new ArrayList<String>();
        urls.add("http://www.51ticket.net/ziliao/yazhou.htm");   //0  1
        urls.add("http://www.51ticket.net/ziliao/ouzhou.htm");   //1  2
        urls.add("http://www.51ticket.net/ziliao/nanmei.htm");   //2  3
        urls.add("http://www.51ticket.net/ziliao/beimei.htm");   //3  3
        urls.add("http://www.51ticket.net/ziliao/feizhou.htm");  //4  4
        urls.add("http://www.51ticket.net/ziliao/aozhou1.htm");  //5  5

        Map<String,Area> areaMap = new HashMap<String, Area>();



        try {

            ParameterizedRowMapper<Area> mapper = new ParameterizedRowMapper<Area>() {
                @Override
                public Area mapRow(ResultSet rs, int i) throws SQLException {
                    Area area = new Area();
                    area.setCitys(new ArrayList<String>());
                    area.setId(rs.getInt(1));
                    area.setName(rs.getString(2));
                    area.setParent(rs.getInt(3));
                    return area;
                }
            };

            ParameterizedRowMapper<Integer> areaCount = new ParameterizedRowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    return rs.getInt(1);
                }
            };

            List<Document> docs = new ArrayList<Document>();
            for (String url : urls) {
                docs.add(Jsoup.connect(url).get());
            }

            String countyName = null;


            for (int k = 0,klength = docs.size(); k < klength ;k++) {
                Document doc = docs.get(k);
                int zhou = 0;
                if(k < 2){
                   zhou = k+1;
                }else if( k ==2 ){
                   zhou = 3;
                }else if( k ==3 ){
                    zhou = 3;
                }else if( k > 3  ){
                    zhou = k;
                }
                Elements element = doc.select("#table1 tr");
                for (int i = 1,length = element.size(); i < length; i++) {
                    if(!Strings.isNullOrEmpty(element.get(i).child(0).text())){
                        countyName = element.get(i).child(0).text();
                        Area area = jdbcTemplate.queryForObject(QUERY_COUNTY_AREA,mapper,countyName);
                        if(!areaMap.containsKey(countyName))
                            areaMap.put(countyName,area);
                    }
                    areaMap.get(countyName).getCitys().add(element.get(i).child(2).text());
                }
                for (int i = 1,length = element.size(); i < length; i++) {
                    if(!Strings.isNullOrEmpty(element.get(i).child(3).text())){
                        countyName = element.get(i).child(3).text();
                        Area area = jdbcTemplate.queryForObject(QUERY_COUNTY_AREA,mapper,countyName);
                        if(!areaMap.containsKey(countyName))
                            areaMap.put(countyName,area);
                    }
                    areaMap.get(countyName).getCitys().add(element.get(i).child(5).text());
                }
            }
            Iterator<Map.Entry<String,Area>> iter = areaMap.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String,Area> entry = iter.next();
                Area area = entry.getValue();
                String sql = "UPDATE AIRPORTCODE SET  COUNTY = "+area.getId()
                        +" ,CONTINENT = "+area.getParent()+" WHERE THREECODE  in ("+area.toCityChain()+")";
                int rows = jdbcTemplate.update(sql) ;
                System.out.println(area.getName()+" : "+rows);
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
