package com.domain.meh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long published;
    String title;
    String content;
    
    public Article() {}
    
    public Article(String title, String content) {
        published = Instant.now().getEpochSecond();
        this.title = title;
        this.content = content;
    }
    
    public Long getId() { return id; }
    public Long getPublished() { return published; }
    public void setPublished() { published = Instant.now().getEpochSecond(); }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    @Override
    public String toString() {
        return "Article{" +
                "published=" + published +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
