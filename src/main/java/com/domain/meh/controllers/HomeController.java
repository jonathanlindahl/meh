package com.domain.meh.controllers;

import com.domain.meh.models.Article;
import com.domain.meh.services.ArticleService;
import com.domain.meh.services.SortingService;
import com.domain.meh.utility.GlobalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ArticleService articleService;
    @Autowired
    SortingService sortingService;
    GlobalStorage storage = GlobalStorage.getInstance();
    
    @RequestMapping("/")
    public String index() {
        List<Article> articles = articleService.getAll();
        for (Article a : articles) {
            if (!containsTitle(storage.getArticles(), a.getTitle()))
                storage.addArticle(a);
        }
        storage.display();
        return "index";
    }
    
    @RequestMapping("/all")
    public String all(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("allarticles", articles);
        return "all";
    }
    
    @RequestMapping("/allsorted")
    public String allSorted(Model model) {
        List<Article> articles =
                sortingService.sortByPublished(articleService.getAll());
        model.addAttribute("allsorted", articles);
        return "allsorted";
    }
    
    @PostMapping("/articles/create")
    public String createArticle(@ModelAttribute Article article) {
        if (!article.getTitle().isBlank() && !article.getContent().isBlank()) {
            articleService.save(article);
        }
        return "index";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("article", new Article());
        return "create";
    }
    
    public boolean containsTitle(List<Article> articles, String title) {
        return articles.stream().anyMatch(a -> a.getTitle().equals(title));
    }
}
