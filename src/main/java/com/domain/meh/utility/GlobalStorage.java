package com.domain.meh.utility;

import com.domain.meh.models.Article;

import java.util.List;

public class GlobalStorage {
    private static GlobalStorage globalStorage;
    private static List<Article> articles;
    
    private GlobalStorage() {
    
    }
    
    public static GlobalStorage getInstance() {
        return globalStorage;
    }
    
    public static List<Article> getArticles() {
        return articles;
    }
    
    public static void addArticle(Article article) {
        articles.add(article);
    }
    
    public static void deleteArticle(Article article) {
        articles.remove(article);
    }
    
    public static void updateArticle(Article article) {
        for (Article a : articles)
            if (a.getId().equals(article.getId())) {
                a.setTitle(article.getTitle());
                a.setContent(article.getContent());
                a.setPublished();
                break;
            }
    }
}
