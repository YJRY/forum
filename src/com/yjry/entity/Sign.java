package com.yjry.entity;

import java.util.Date;

public class Sign extends BaseEntity {
    private String user;
    private Date time;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
