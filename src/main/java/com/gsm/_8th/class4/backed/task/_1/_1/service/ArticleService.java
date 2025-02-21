package com.gsm._8th.class4.backed.task._1._1.service;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return ResponseEntity.ok(articles);
    }

    public ResponseEntity<Article> getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Article> createArticle(Article article) {
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.ok(savedArticle);
    }

    public ResponseEntity<Article> updateArticle(Long id, Article articleDetails) {
        return articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.setTitle(articleDetails.getTitle());
                    existingArticle.setContent(articleDetails.getContent());
                    Article updatedArticle = articleRepository.save(existingArticle);
                    return ResponseEntity.ok(updatedArticle);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteArticle(Long id) {
        return articleRepository.findById(id)
                .map(article -> {
                    articleRepository.delete(article);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
} 