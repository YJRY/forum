package com.yjry.service.impl;

import com.yjry.dao.PostDao;
import com.yjry.entity.Post;
import com.yjry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Post getPostById(int id) {
        return postDao.getPostById(id);
    }

    @Override
    public int addPost(String username, String title, String content, int type) {
        return postDao.addPost(username, title, content, type);
    }

    @Override
    public int getRowCount() {
        return postDao.getRowCount();
    }

    @Override
    public int getRowCountByType(int type) {
        return postDao.getRowCountByType(type);
    }

    @Override
    public List<Post> getLatestData() {
        return postDao.getLatestData();
    }

    @Override
    public List<Post> getHotData() {
        return postDao.getHotData();
    }

    @Override
    public List<Post> getDataByType(int type) {
        return postDao.getDataByType(type);
    }

    @Override
    public List<Post> getDataByUser(String username) {
        return postDao.getDataByUser(username);
    }

    @Override
    public List<Post> getDataByPageAndType(int page, int type, int count) {
        return postDao.getDataByPageAndType(page, type, count);
    }
}
