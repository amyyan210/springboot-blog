package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {

    private PostsRepository postsDao;

    @Autowired // Only necessary when you have more than one constructor
    // Constructor injection
    public PostSvc(PostsRepository postsDao) {

        this.postsDao = postsDao;
    }


//    public PostSvc() {
//        createDummy();
//    }

//    retrieving all the posts
    // Iterable is super class of lists
    public Iterable<Post> findAll(){

        return postsDao.findAll();
    }

//    finding a post (retrieving an individual post object)
    public Post findOne(Long id) {
        return postsDao.findOne(id);
    }

    public Post save(Post post) {
        postsDao.save(post);
        return post;
    }

    public Post delete(Post post) {
        postsDao.delete(post);
        return post;
    }

//    private void createDummy(){
//
//        save(new Post(
//                1L,
//                "Example 1",
//                "1 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"
//        ));
//
//        save(new Post(
//                2L,
//                "Example 2",
//                "2 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"
//        ));
//
//    }
}
