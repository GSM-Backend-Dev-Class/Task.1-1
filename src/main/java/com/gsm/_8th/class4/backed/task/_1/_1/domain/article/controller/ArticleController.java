package com.gsm._8th.class4.backed.task._1._1.domain.article.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleInfoDTO;
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
    private final ArticleRepository articleRepository;

    @GetMapping
    public ResponseEntity<List<ArticleEntity>> getArticles() {
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleEntity> getArticleById(@PathVariable Long id) {
        if(!(articleRepository.existsById(id))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(articleService.viewArticle(id));
    }

    @PostMapping
    public ResponseEntity<?> postArticle(@Valid @RequestBody ArticleInfoDTO articleInfoDTO) {
        articleService.postArticle(articleInfoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editArticle(@PathVariable Long id, @Valid @RequestBody ArticleInfoDTO articleInfoDTO) {
        if(!(articleRepository.existsById(id))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        articleService.editArticle(id, articleInfoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        if(!(articleRepository.existsById(id))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        articleRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}