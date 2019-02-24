package com.yjry.service;

import com.yjry.entity.Sign;

public interface SignService {
    Sign getSign(String username);
    boolean hasSign(String username);
    int addSign(String username);
}
