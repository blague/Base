package org.zj.service;

import com.google.common.io.Files;
import net.sf.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zj.citycontrol.dao.AreaDao;
import org.zj.citycontrol.model.Area;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class GenerateCN {

    public static void main(String[] args) throws IOException {
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AreaDao areaDao  = appContext.getBean("areaDao", AreaDao.class);
//        List<Area> list = areaDao.getArea(true);
//        String areaJson = JSONArray.fromObject(list).toString();
//        Files.write(areaJson.getBytes(),new File("iAirPort.js"));

        String out = "";
        Properties propites = System.getProperties();
        Enumeration enums = propites.propertyNames();
        while(enums.hasMoreElements()){
            String key = enums.nextElement().toString();
            out += key + " : " + propites.getProperty(key) + "\r\n";
        }

    }
}
