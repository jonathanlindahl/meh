package com.domain.meh.services;

import com.domain.meh.models.Article;
import com.domain.meh.repositories.ArticleRepository;
import com.domain.meh.utility.GlobalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    GlobalStorage storage = GlobalStorage.getInstance();
    
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
    
    public Article getById(Long id) {
        if (articleRepository.findById(id).isPresent())
            return articleRepository.findById(id).get();
        throw new NoSuchElementException();
    }
    
    public Article getByPublished(Long published) {
        if (articleRepository.findByPublished(published) != null)
            return articleRepository.findByPublished(published);
        throw new NoSuchElementException();
    }
    
    public Article getByTitle(String title) {
        return articleRepository.findByTitle(title);
    }
    
    public Article save(Article newArticle) {
        storage.addArticle(newArticle);
        return articleRepository.save(newArticle);
    }
    
    public Article update(Article article) {
        Article oldArticle = getById(article.getId());
        if (oldArticle != null) {
            oldArticle.setPublished();
            oldArticle.setTitle(article.getTitle());
            oldArticle.setContent(article.getContent());
            storage.updateArticle(oldArticle);
            return articleRepository.save(oldArticle);
        }
        throw new NoSuchElementException();
    }
    
    public void delete(Long id) {
        if (getById(id) != null) {
            storage.deleteArticle(getById(id));
            articleRepository.delete(getById(id));
        }
        else
            throw new NoSuchElementException();
    }
}
