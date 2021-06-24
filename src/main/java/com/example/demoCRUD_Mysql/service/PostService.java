package com.example.demoCRUD_Mysql.service;

import com.example.demoCRUD_Mysql.entity.Post;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface PostService extends Serializable {




    List<Post> getAllPost();

    void savePost(Post post);

    void deletePost(Long id);

    Optional<Post> findPostById(Long id);

    List<Post> findByTitleContaining(String title);
    List<Post> findAllByOrderByIdDesc();

}

