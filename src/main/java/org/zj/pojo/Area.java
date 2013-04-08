package org.zj.pojo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 地区信息
 */
public class Area  {

    private int id;

    private String name;

    private int parent;

    /**
     * 所在国家的机场三字码集合
     */
    private List<String> citys;

    public Area() {
    }

    public Area(String name) {
        this.name = name;
        this.citys = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public List<String> getCitys() {
        return citys;
    }

    public void setCitys(List<String> citys) {
        this.citys = citys;
    }

    public String toCityChain(){
        StringBuffer sb = new StringBuffer();
        for (String str : this.citys){
             sb.append("'").append(str).append("'");
        }
        return sb.toString().replaceAll("''","','");
    }
}
