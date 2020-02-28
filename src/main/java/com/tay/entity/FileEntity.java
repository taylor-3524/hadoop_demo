package com.tay.entity;

public class FileEntity {
    private int id;
    private String path;
    private String name;
    private long len;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }


}
