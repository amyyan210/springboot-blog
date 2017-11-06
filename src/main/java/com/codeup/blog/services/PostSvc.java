package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {

//    The service should keep an array list of posts internally
    private List<Post> posts = new ArrayList<>();

    public PostSvc() {
        createDummy();
    }
//    retrieving all the posts
    public List<Post> findAll(){
        return posts;
    }

//    finding a post (retrieving an individual post object)
    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    private void createDummy(){
        Post post1 = new Post();

        post1.setTitle("Example 1");
        post1.setBody("1 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!");
        posts.add(0, post1);

        Post post2 = new Post();
        post2.setTitle("Example 2");
        post2.setBody("2 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!");
        posts.add(1, post2);

        Post post3 = new Post();
        post3.setTitle("Example 3");
        post3.setBody("3 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!");
        posts.add(2, post3);

    }



}
