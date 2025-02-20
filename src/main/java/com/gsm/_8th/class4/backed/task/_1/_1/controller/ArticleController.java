package com.gsm._8th.class4.backed.task._1._1.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
        return articleService.getArticleById(articleId);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long articleId, @RequestBody Article articleDetails) {
        return articleService.updateArticle(articleId, articleDetails);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        return articleService.deleteArticle(articleId);
    }
} 