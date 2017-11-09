package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    private final PostSvc postSvc;
    private final UsersRepository usersRepository;

    @Autowired // Only necessary when you have more than one constructor
    // Constructor injection - in order to be able to use the users properties / methods from the Post class
    public PostsController(PostSvc postSvc, UsersRepository usersRepository) {
        this.postSvc = postSvc;
        this.usersRepository = usersRepository;
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
    @GetMapping("/posts/{id}")
    public String viewPost (@PathVariable Long id, Model model) {

        model.addAttribute("post", postSvc.findOne(id));
        // points to the path
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm (Model model) {

        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
//    @modelattribute connects to the form th:object
    public String createPost (@ModelAttribute Post post) {
        User user1 = usersRepository.findOne(1L);
        post.setUser(user1);

        postSvc.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm (Model model, @PathVariable Long id) {

        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editForm (@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/delete")
    public String viewDeleteForm (@PathVariable Long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/delete";
    }

    @PostMapping("posts/{id}/delete")
    public String deletePost (@ModelAttribute Post post) {
        postSvc.delete(post);
        return "redirect:/posts";
    }

}
