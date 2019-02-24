package com.yjry.service.impl;

import com.yjry.dao.SignDao;
import com.yjry.entity.Sign;
import com.yjry.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignServiceImpl implements SignService {

    @Autowired
    private SignDao signDao;

    @Override
    public Sign getSign(String username) {
        return signDao.getSign(username);
    }

    @Override
    public boolean hasSign(String username) {
        Sign sign = signDao.getSign(username);
        return (sign != null);
    }

    @Override
    public int addSign(String username) {
        return signDao.addSign(username);
    }
}
