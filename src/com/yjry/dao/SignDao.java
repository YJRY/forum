package com.yjry.dao;

import com.yjry.entity.Sign;
import org.springframework.stereotype.Repository;

@Repository
public interface SignDao {
    Sign getSign(String username);
    int addSign(String username);
}
