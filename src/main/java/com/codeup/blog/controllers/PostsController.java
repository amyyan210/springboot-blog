package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts () {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost () {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String formPosts () {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPosts () {
        return "create a new post";
    }

}
