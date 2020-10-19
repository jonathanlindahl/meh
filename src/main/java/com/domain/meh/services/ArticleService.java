package com.domain.meh.services;

import com.domain.meh.models.Article;
import com.domain.meh.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
    
    public Optional<Article> getByPublished(@RequestParam Long published) {
        return articleRepository.findById(published);
    }
    
    public Article getByTitle(@RequestParam String title) {
        return articleRepository.findByTitle();
    }
}
