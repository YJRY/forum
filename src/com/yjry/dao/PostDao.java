package com.yjry.dao;

import com.yjry.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
    List<Post> getLatestData();
    List<Post> getHotData();
    List<Post> getDataByType(int type);
    List<Post> getDataByUser(String username);
    Post getPostById(int id);
    int addPost(@Param("username") String username, @Param("title") String title, @Param("content") String content, @Param("type") int type);
    List<Post> getDataByPageAndType(@Param("page") int page, @Param("type") int type, @Param("count") int count);
    int getRowCount();
    int getRowCountByType(int type);
}
