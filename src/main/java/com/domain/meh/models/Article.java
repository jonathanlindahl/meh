package com.domain.meh.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    Long published;
    String title;
    String content;
    
    public Article() {}
    
    public Article(Long published, String title, String content) {
        this.published = published;
        this.title = title;
        this.content = content;
    }
    
    public Long getPublished() { return published; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    
    @Override
    public String toString() {
        return "Article{" +
                "published=" + published +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
