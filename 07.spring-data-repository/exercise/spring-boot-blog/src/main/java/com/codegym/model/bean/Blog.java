package com.codegym.model.bean;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nameAuthor;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    private String content;
    @Column(name = "date",columnDefinition = "Date")
    private String date;

    public Blog() {
    }

    public Blog(int id, String name, String nameAuthor, Category category, String content, String date) {
        this.id = id;
        this.name = name;
        this.nameAuthor = nameAuthor;
        this.category = category;
        this.content = content;
        this.date = date;
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

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
