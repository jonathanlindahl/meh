package com.domain.meh.controllers;

import com.domain.meh.models.Article;
import com.domain.meh.services.ArticleService;
import com.domain.meh.services.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SortingService sortingService;
    
    @GetMapping("articles/all")
    public List<Article> getAll() {
        return articleService.getAll();
    }
    
    @GetMapping("articles/allsorted")
    public List<Article> getAllSorted() {
        return sortingService.sortByPublished(getAll());
    }
    
    @GetMapping("articles/getbyid")
    public Article getById(@RequestParam Long id) {
        return articleService.getById(id);
    }
    
    @GetMapping("articles/getbytitle")
    public Article getByTitle(@RequestParam String title) {
        return articleService.getByTitle(title);
    }
    
    @GetMapping("articles/getbypublished")
    public Article getByPublished(@RequestParam Long published) {
        return articleService.getByPublished(published);
    }
    
//    @PostMapping("articles/create")
//    public Article newArticle(@RequestBody Article newArticle) {
//        return articleService.save(newArticle);
//    }
    
//    @PutMapping("articles/update")
//    public Article updateArticle(@RequestBody Article article) {
//        return articleService.update(article);
//    }
    
//    @DeleteMapping("articles/delete")
//    public void deleteArticle(@RequestParam Long id) {
//        articleService.delete(id);
//    }
}
