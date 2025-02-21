package com.gsm._8th.class4.backed.task._1._1.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.dto.ArticleRequestDTO;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(@Qualifier("articleServiceImpl") ArticleService articleService) {
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
    public CompletableFuture<ResponseEntity<Article>> createArticle(@RequestBody ArticleRequestDTO articleDTO) {
        validateArticleDTO(articleDTO);
        Article article = articleDTO.toEntity();
        return articleService.createArticle(article).thenApply(ResponseEntity::ok);
    }

    @PatchMapping("/{articleId}")
    public CompletableFuture<ResponseEntity<Article>> updateArticle(@PathVariable Long articleId, @RequestBody ArticleRequestDTO articleDTO) {
        validateArticleDTO(articleDTO);
        Article articleDetails = articleDTO.toEntity();
        return articleService.updateArticle(articleId, articleDetails)
                .thenApply(updatedArticle -> updatedArticle.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{articleId}")
    public CompletableFuture<ResponseEntity<Void>> deleteArticle(@PathVariable Long articleId) {
        return articleService.deleteArticle(articleId)
                .thenApply(deleted -> deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build());
    }

    private void validateArticleDTO(ArticleRequestDTO articleDTO) {
        if (articleDTO.getTitle() == null || articleDTO.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title에 뭐라도 써주세요...");
        }
        if (articleDTO.getTitle().length() > 100) {
            throw new IllegalArgumentException("Title은 100자를 넘을 수 없습니다.");  
        }
        if (articleDTO.getContent() == null || articleDTO.getContent().isBlank()) {
            throw new IllegalArgumentException("Content에 뭐라도 써주세요...");
        }
        if (articleDTO.getContent().length() > 1000) {
            throw new IllegalArgumentException("Content는 1000자를 넘을 수 없습니다.");
        }
    }
} 