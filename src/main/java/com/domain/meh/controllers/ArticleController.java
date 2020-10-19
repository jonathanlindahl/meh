package com.domain.meh.controllers;

import com.domain.meh.models.Article;
import com.domain.meh.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    
    @GetMapping("/all")
    public List<Article> getAll() {
        return articleService.getAll();
    }
    
    @GetMapping("/getbyid")
    public Article getById(@RequestParam Long id) {
        return articleService.getById(id);
    }
    
    @GetMapping("/getbytitle")
    public Article getByTitle(@RequestParam String title) {
        return articleService.getByTitle(title);
    }
    
    @GetMapping("/getbypublished")
    public Article getByPublished(@RequestParam Long published) {
        return articleService.getByPublished(published);
    }
    
    @PostMapping("/newarticle")
    public Article newArticle(@RequestBody Article newArticle) {
        return articleService.save(newArticle);
    }
    
    @PutMapping("/updatearticle")
    public Article updateArticle(@RequestBody Article article) {
        return articleService.update(article);
    }
    
    @DeleteMapping("/deletearticle")
    public void deleteArticle(@RequestParam Long id) {
        articleService.delete(id);
    }
}
