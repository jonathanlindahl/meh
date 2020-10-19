package com.domain.meh.services;

import com.domain.meh.models.Article;
import com.domain.meh.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
    
    public Article getById(@RequestParam Long id) {
        if (articleRepository.findById(id).isPresent())
            return articleRepository.findById(id).get();
        throw new NoSuchElementException();
    }
    
    public Article getByPublished(@RequestParam Long published) {
        if (articleRepository.findByPublished(published) != null)
            return articleRepository.findByPublished(published);
        throw new NoSuchElementException();
    }
    
    public Article getByTitle(@RequestParam String title) {
        return articleRepository.findByTitle(title);
    }
    
    public Article save(@RequestBody Article newArticle) {
        return articleRepository.save(newArticle);
    }
    
    // TODO: does this actually return the article object
    public Article update(@RequestBody Article article) {
        Article oldArticle = getById(article.getId());
        if (oldArticle != null) {
            oldArticle.setPublished();
            oldArticle.setTitle(article.getTitle());
            oldArticle.setContent(article.getContent());
            return oldArticle;
        }
        throw new NoSuchElementException();
    }
    
    public void delete(@RequestParam Long id) {
        if (getById(id) != null)
            articleRepository.delete(getById(id));
        throw new NoSuchElementException();
    }
}
