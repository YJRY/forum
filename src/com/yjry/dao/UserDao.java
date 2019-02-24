package com.yjry.dao;

import com.yjry.entity.Post;
import com.yjry.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
    User getUserByName(String name);
    User getUserById(int id);
    User getUserByPost(Post post);
    int addUser(@Param("name") String name, @Param("pwd") String pwd);
    int changeUser(@Param("id") int id, @Param("email") String email, @Param("sex") String sex);
    int changePwd(@Param("id") int id, @Param("pwd") String pwd);
    int addImagePath(@Param("id") int id, @Param("path") String path);
}
