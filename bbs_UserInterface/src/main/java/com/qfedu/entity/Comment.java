package com.qfedu.entity;

import java.sql.Timestamp;

public class Comment {
    private Integer pid;
    private String pcontent;
    private Integer userid;
    private Integer byid;
    private Timestamp time;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getByid() {
        return byid;
    }

    public void setByid(Integer byid) {
        this.byid = byid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
