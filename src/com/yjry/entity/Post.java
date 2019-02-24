package com.yjry.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.yjry.pojo.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post extends BaseEntity {
    private String user;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String title;
    private String content;
    private Integer type;
    private Integer tunum;
    private Data<Post> data;

    public Data<Post> getData() {
        return data;
    }

    public void setData(Data<Post> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user='" + user + '\'' +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", tunum=" + tunum +
                ", id=" + id +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTunum() {
        return tunum;
    }

    public void setTunum(Integer tunum) {
        this.tunum = tunum;
    }
}
