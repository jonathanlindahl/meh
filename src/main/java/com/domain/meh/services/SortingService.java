package com.domain.meh.services;

import com.domain.meh.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {
    public List<Article> sortByPublished(List<Article> articles) {
        articles.sort(Article::compareTo);
        return articles;
    }
//    @Autowired
//    static ArticleService articleService;
//    public static void sortByPublished() {
//        List<Article> articles = articleService.getAll();
//        articles.sort((article1, article2) -> {
//            if(!article1.getPublished().equals(article2.getPublished()))
//                return Long.compare(article1.getPublished(), article2.getPublished());
//            else
//                return article1.getTitle().compareToIgnoreCase(article2.getTitle());
//        });
//    }
}
