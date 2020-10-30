package com.domain.meh.controllers;

import com.domain.meh.models.Article;
import com.domain.meh.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ArticleService articleService;
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/all")
    public String all(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("allarticles", articles);
        return "all";
    }
}
