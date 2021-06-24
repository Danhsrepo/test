 package com.example.demoCRUD_Mysql.controller;

import com.example.demoCRUD_Mysql.entity.Post;
import com.example.demoCRUD_Mysql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;



    @RequestMapping("/")
    public String index(Model model) {

        List<Post> posts = postService.findAllByOrderByIdDesc();
        model.addAttribute("posts", posts);
        return "index";
    }


    @RequestMapping("/index")
    public String back(Model model) {

        List<Post> posts = postService.findAllByOrderByIdDesc();
        model.addAttribute("posts",  posts);
        return "index";
    }

    @RequestMapping(value = "post")
    public String Post(Model model) {
        model.addAttribute("post", new Post());
        return "post";
    }







    @GetMapping("search")
    public String Search(ModelMap model,
                         @RequestParam(name = "title",required = false) String title) {

        List<Post> list = null;
        if (StringUtils.hasText(title)) {
            list = postService.findByTitleContaining(title);
        } else {
            list = postService.getAllPost();
        }
        model.addAttribute("posts", list);
        return "search";
    }



    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPost(@RequestParam("id") Long postId, Model model) {
        Optional<Post> postEdit = postService.findPostById(postId);
        postEdit.ifPresent(post -> model.addAttribute("post", post));
        return "editPost";
    }



    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Post post) {
        postService.savePost(post);
        return "redirect:/";
    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePost(@RequestParam("id") Long postId, Model model) {
        postService.deletePost(postId);
        return "redirect:/";
    }
/*
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPost(@RequestParam("id") Long postId, Model model) {
        postService.searchPost(postId);
        return "redirect:/";
    }*/




}
