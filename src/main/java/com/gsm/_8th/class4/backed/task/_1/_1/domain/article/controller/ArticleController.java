package com.gsm._8th.class4.backed.task._1._1.domain.article.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleInfo;
import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleResponse;
import com.gsm._8th.class4.backed.task._1._1.domain.article.entity.ArticleEntity;
import com.gsm._8th.class4.backed.task._1._1.domain.article.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.domain.article.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.viewArticle(id);
        return ResponseEntity.status(HttpStatus.OK).body(articleResponse);
    }

    @PostMapping
    public ResponseEntity<?> postArticle(@Valid @RequestBody ArticleInfo articleInfo) {
        articleService.postArticle(articleInfo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editArticle(@PathVariable Long id, @Valid @RequestBody ArticleInfo articleInfo) {
        articleService.editArticle(id, articleInfo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}