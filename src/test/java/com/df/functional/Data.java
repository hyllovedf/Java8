package com.df.functional;

/**
 * create by hanyli 2019/11/29
 */
public class Data {
    private String id;
    private String parent;

    public Data(String id, String parent) {
        this.id = id;
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}




