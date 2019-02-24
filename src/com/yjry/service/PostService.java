package com.yjry.service;

import com.yjry.entity.Post;

import java.util.List;

public interface PostService {
    Post getPostById(int id);
    int addPost(String username, String title, String content, int type);
    int getRowCount();
    int getRowCountByType(int type);
    List<Post> getLatestData();
    List<Post> getHotData();
    List<Post> getDataByType(int type);
    List<Post> getDataByUser(String username);
    List<Post> getDataByPageAndType(int page, int type, int count);
}
