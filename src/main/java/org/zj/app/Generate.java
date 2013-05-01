package org.zj.app;


import com.google.common.io.Files;
import net.sf.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.zj.pojo.City;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Generate {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);

        ParameterizedRowMapper<City> cityMapper = new ParameterizedRowMapper<City>() {
            @Override
            public City mapRow(ResultSet rs, int i) throws SQLException {
                City city = new City();
                city.setId(rs.getString(1));
                city.setName(rs.getString(2));
                city.setCode(rs.getString(3));
                city.setEn(rs.getString(4));
                city.setPyjsm(rs.getString(5));
                return city;
            }
        };

//      List<City> list =jdbcTemplate.query("select BH,MC,HXID,YWMC,PYJSM from ve_city where gngj = 1 and ywjc = 1",cityMapper);

        Map<String,List<City>> map = new LinkedHashMap<String, List<City>>();

        String khid = "1";//TODO 这里以后要从全局参数中获取
        String hotCity = jdbcTemplate.queryForObject("select csz1 from ve_pt_cs where csbh='7810' and khid = ?", new Object[]{khid}, String.class);
        String[] hotCities = hotCity.split("@");
        List<City> cities = new ArrayList<City>();
        for (int i = 0; i < hotCities.length; i++) {
            String[] c = hotCities[i].split("\\|");
            City city = new City();
            city.setEn(c[0]);
            city.setName(c[1]);
            city.setCode(c[2]);
            cities.add(city);
        }
        map.put("热门城市",cities);

        Map<String,String> abcs = new LinkedHashMap<String, String>();
        abcs.put("ABCDE","A-E"); abcs.put("FGHIJ","F-J"); abcs.put("KLMNO","K-O"); abcs.put("PQRST","P-T"); abcs.put("UVWXYZ","U-Z");
        Iterator<Map.Entry<String, String>> iter = abcs.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            List<City> list =jdbcTemplate.query("select BH,MC,HXID,YWMC,PYJSM from ve_city where gngj = 1 and ywjc = 1 and regexp_like(PYJSM,'^[" + entry.getValue() + "]')", cityMapper);
            map.put(entry.getKey(),list);
        }



       Map<String,Map<String,List<City>>>  ci = new HashMap<String, Map<String, List<City>>>();
        ci.put("国内城市",map);
        ci.put("国际城市", null);

        String json = JSONArray.fromObject(ci).toString();
        json = "var cityList = "+json;
        try {
            Files.write(json.getBytes("UTF-8"),new File("D:/cityList.js"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
