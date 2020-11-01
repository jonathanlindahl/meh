package com.domain.meh.utility;

import com.domain.meh.models.Article;

import java.util.ArrayList;
import java.util.List;

public class GlobalStorage {
    private static final GlobalStorage globalStorage = new GlobalStorage();
    private List<Article> articles;
    
    private GlobalStorage() {
        articles = new ArrayList<>();
    }
    
    public static GlobalStorage getInstance() {
        return globalStorage;
    }
    
    public List<Article> getArticles() {
        return articles;
    }
    
    public void addArticle(Article article) {
        articles.add(article);
    }
    
    public void deleteArticle(Article article) {
        articles.remove(article);
    }
    
    public void updateArticle(Article article) {
        for (Article a : articles)
            if (a.getId().equals(article.getId())) {
                a.setTitle(article.getTitle());
                a.setContent(article.getContent());
                a.setPublished();
                break;
            }
    }
    
    public void display() {
        System.out.println("displaying...");
        for (Article a : articles)
            System.out.println(a.toString());
    }
}
