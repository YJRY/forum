package com.yjry.service;

import com.yjry.entity.Post;
import com.yjry.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);
    User getUserByNameAndPwd(String name, String pwd);
    User getUserByName(String name);
    User getUserByPost(Post post);
    List<User> getUsersByPost(List<Post> postList);
    boolean hasUser(String name, String pwd);
    boolean isReg(String name);
    int addUser(String name, String pwd);
    int changeUser(int id, String email, String sex);
    int changePwd(int id, String pwd);
    int addImagePath(int id, String path);
}
