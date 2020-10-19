package com.domain.meh.controllers;

import com.domain.meh.models.Article;
import com.domain.meh.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    
    @GetMapping("/all")
    public List<Article> getAll() {
        return articleService.getAll();
    }
}
