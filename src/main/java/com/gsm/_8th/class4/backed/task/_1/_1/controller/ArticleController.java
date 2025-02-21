package com.gsm._8th.class4.backed.task._1._1.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Article>>> getAllArticles() {
        return articleService.getAllArticles().thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{articleId}")
    public CompletableFuture<ResponseEntity<Article>> getArticleById(@PathVariable Long articleId) {
        return articleService.getArticleById(articleId)
                .thenApply(article -> article.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Article>> createArticle(@RequestBody Article article) {
        return articleService.createArticle(article).thenApply(ResponseEntity::ok);
    }

    @PatchMapping("/{articleId}")
    public CompletableFuture<ResponseEntity<Article>> updateArticle(@PathVariable Long articleId, @RequestBody Article articleDetails) {
        return articleService.updateArticle(articleId, articleDetails)
                .thenApply(article -> article.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{articleId}")
    public CompletableFuture<ResponseEntity<Void>> deleteArticle(@PathVariable Long articleId) {
        return articleService.deleteArticle(articleId)
                .thenApply(deleted -> deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build());
    }
} 