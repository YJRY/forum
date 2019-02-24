package com.yjry.service.impl;

import com.yjry.dao.ExpDao;
import com.yjry.entity.Exp;
import com.yjry.entity.User;
import com.yjry.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ExpServiceImpl implements ExpService {

    @Autowired
    private ExpDao expDao;

    @Override
    public int addExp(int num, int id) {
        return expDao.addExp(num, id);
    }

    @Override
    public Exp getDataByExp(int exp) {
        return expDao.getDataByExp(exp);
    }

    @Override
    public List<Exp> getExpsByUser(List<User> userList) {
        Iterator<User> it = userList.iterator();
        List<Exp> expList = new ArrayList<>();
        while(it.hasNext()){
            expList.add(getDataByExp(it.next().getExp()));
        }
        return expList;
    }
}
