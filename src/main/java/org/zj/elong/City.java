package org.zj.elong;

public class City {
    private String id;
    private String name;
    private String ename;


    public City() {
    }

    public City(String id, String name, String ename) {
        this.id = id;
        this.name = name;
        this.ename = ename;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
