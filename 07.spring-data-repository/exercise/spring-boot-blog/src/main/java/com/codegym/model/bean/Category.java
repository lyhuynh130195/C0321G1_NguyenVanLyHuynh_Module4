package com.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    private String name;

    public Category() {
    }

    public Category(int id, Set<Blog> blogs, String name) {
        this.id = id;
        this.blogs = blogs;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
