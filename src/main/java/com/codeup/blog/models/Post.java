package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable=false)
    private String body;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post (Long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getTitle () {
        return this.title;
    }

    public String getBody () {
        return this.body;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setBody (String body) {
        this.body = body;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
