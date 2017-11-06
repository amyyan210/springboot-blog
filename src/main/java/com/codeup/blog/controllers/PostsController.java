package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
public class PostsController {

    private final PostSvc postSvc;

    @Autowired // Only necessary when you have more than one constructor
    // Constructor injection
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    // not related to the path
    // url (in this case, in address bar)
    @GetMapping("/posts")
    // not using @responsebody anymore because we want to load the template view instead of returning just text
    public String viewPosts (Model model) {

        model.addAttribute("posts", postSvc.findAll());

        // points to the path where the view lives
        return "posts/index";
    }

    // not related to the path
    @GetMapping("/show/{id}")
    public String viewPost (@PathVariable long id, Model model) {

        model.addAttribute("post", postSvc.findOne(id));

        // points to the path
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String viewCreateForm () {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost () {
        return "create a new post";
    }

}
