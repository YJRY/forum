package com.yjry.service.impl;

import com.yjry.dao.UserDao;
import com.yjry.entity.Post;
import com.yjry.entity.User;
import com.yjry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id){
        return userDao.getUserById(1);
    }

    @Override
    public User getUserByNameAndPwd(String name, String pwd){
        return userDao.getUserByNameAndPwd(name, pwd);
    }

    @Override
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    @Override
    public User getUserByPost(Post post){
        return userDao.getUserByName(post.getUser());
    }

    @Override
    public List<User> getUsersByPost(List<Post> postList) {
        Iterator<Post> it = postList.iterator();
        List<User> userList = new ArrayList<>();
        while(it.hasNext()){
            userList.add(userDao.getUserByName(it.next().getUser()));
        }
        return userList;
    }

    @Override
    public boolean hasUser(String name, String pwd){
        User user = userDao.getUserByNameAndPwd(name, pwd);
        return !(user == null);
    }

    @Override
    public boolean isReg(String name){
        User user = userDao.getUserByName(name);
        return!(user == null);
    }

    @Override
    public int addUser(String name, String pwd){
        return userDao.addUser(name, pwd);
    }

    @Override
    public int changeUser(int id, String email, String sex){
        return userDao.changeUser(id, email, sex);
    }

    @Override
    public int changePwd(int id, String pwd){
        return userDao.changePwd(id, pwd);
    }

    @Override
    public int addImagePath(int id, String path){
        return userDao.addImagePath(id, path);
    }
}
