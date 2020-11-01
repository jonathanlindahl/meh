package com.domain.meh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.Instant;

@Entity
@Table(name = "articles")
public class Article implements Comparable<Article> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long published;
    private String title;
    private String content;
    
    public Article() {
        published = Instant.now().getEpochSecond();
    }
    
    public Article(String title, String content) {
        published = Instant.now().getEpochSecond();
        this.title = title;
        this.content = content;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPublished() { return published; }
    public void setPublished() { published = Instant.now().getEpochSecond(); }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    @Override
    public int compareTo(Article a) {
        return Long.compare(this.published, a.getPublished());
    }
    
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", published=" + published +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
