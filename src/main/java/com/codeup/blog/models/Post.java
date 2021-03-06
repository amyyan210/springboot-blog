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

    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post (Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
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
}
