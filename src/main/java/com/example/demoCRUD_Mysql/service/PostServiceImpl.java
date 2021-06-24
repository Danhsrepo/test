package com.example.demoCRUD_Mysql.service;

import com.example.demoCRUD_Mysql.entity.Post;
import com.example.demoCRUD_Mysql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> findByTitleContaining(String title) {
        return postRepository.findByTitleContaining(title);
    }

    @Override
    public List<Post> findAllByOrderByIdDesc() {
        return postRepository.findAllByOrderByIdDesc();
    }




    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }





    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }
}
