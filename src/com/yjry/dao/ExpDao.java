package com.yjry.dao;

import com.yjry.entity.Exp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpDao {
    int addExp(@Param("num") int num, @Param("id") int id);
    Exp getDataByExp(int exp);
}
