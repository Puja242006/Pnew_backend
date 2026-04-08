package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discussions")
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String author;
    private String category;

    // 🔥 ADD THIS
    private int likes;

    public Discussion() {}

    public Discussion(String title, String description, String author, String category) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = category;
        this.likes = 0;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // 🔥 GETTER/SETTER FOR LIKES
    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }
}