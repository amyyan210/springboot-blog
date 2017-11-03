package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
public class PostsController {

    // not related to the path
    // url (in this case, in address bar)
    @GetMapping("/posts")
    // not using @responsebody anymore because we want to load the template view instead of returning just text
    public String viewPosts (Model model) {

//        create a new array list and add two post objects to it,             then pass that list to the view.
        ArrayList<Object> listOfPosts = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Post #1");
        post1.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        Post post2 = new Post();
        post2.setTitle("Post #2");
        post2.setBody("Blah blah blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah");

        listOfPosts.add(0, post1);
        listOfPosts.add(1, post2);
        model.addAttribute("listOfPosts", listOfPosts);

        // points to the path where the view lives
        return "posts/index";
    }

    // not related to the path
    @GetMapping("/show/{id}")
    public String viewPost (@PathVariable int id, Model model) {
//        create a new post object and pass it to the view
        Post post = new Post();
        post.setTitle("My Post");
        post.setBody("Domestic confined any but son bachelor advanced remember. How proceed offered her offence shy forming. Returned peculiar pleasant but appetite differed she. Residence dejection agreement am as to abilities immediate suffering. Ye am depending propriety sweetness distrusts belonging collected. Smiling mention he in thought equally musical. Wisdom new and valley answer. Contented it so is discourse recommend. Man its upon him call mile. An pasture he himself believe ferrars besides cottage.");
        model.addAttribute("post", post);

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
