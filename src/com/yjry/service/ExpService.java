package com.yjry.service;

import com.yjry.entity.Exp;
import com.yjry.entity.User;

import java.util.List;

public interface ExpService {

    int addExp(int num, int id);
    Exp getDataByExp(int exp);
    List<Exp> getExpsByUser(List<User> userList);
}
