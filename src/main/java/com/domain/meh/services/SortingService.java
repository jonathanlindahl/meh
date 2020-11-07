package com.domain.meh.services;

import com.domain.meh.models.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {
    public List<Article> sortByPublished(List<Article> articles) {
        articles.sort(Article::compareTo);
        return articles;
    }
}
