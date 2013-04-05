package org.zj.poi;

import  org.jsoup.nodes.Document;
import  org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ReadWord {

    public static final  String path = "C:\\Users\\blague\\Downloads\\机场代码.doc";

    public static void main(String[] args) {
        String url = "http://www.feeyo.com/airport_code.asp?page=";
        try {
            for (int k = 1; k <=60 ; k++) {
                Document doc = Jsoup.connect(url+k).get();
                Elements element = doc.select(".tab_hand tr");
                for (int i = 1,length = element.size()-1; i < length ; i++) {
                    Elements tds = element.get(i).select("td");
                    System.out.print("insert into AIRPORTCODE  VALUES(");
                    for (int j = 0,jlenth = tds.size()-1; j < jlenth ; j++) {
                        System.out.print("'"+tds.get(j).text() + "'");
                    }
                    System.out.println(");");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
