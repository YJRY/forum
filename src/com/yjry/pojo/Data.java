package com.yjry.pojo;

import com.yjry.entity.Exp;
import com.yjry.entity.User;

import java.util.List;

public class Data<T> {
    private Page page;
    private List<T> dataList;
    private List<User> userList;
    private List<Exp> expList;

    public List<Exp> getExpList() {
        return expList;
    }

    public void setExpList(List<Exp> expList) {
        this.expList = expList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Data(Page page, List<T> dataList, List<User> userList, List<Exp> expList) {
        this.page = page;
        this.dataList = dataList;
        this.userList = userList;
        this.expList = expList;
    }

    public Data() {
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
