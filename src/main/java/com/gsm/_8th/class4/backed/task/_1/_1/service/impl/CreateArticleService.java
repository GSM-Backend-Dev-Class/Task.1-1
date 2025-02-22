package com.gsm._8th.class4.backed.task._1._1.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.Optional;

@Service
public class CreateArticleService implements ArticleService {

    private final ArticleRepository articleRepository;

    public CreateArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Async
    public CompletableFuture<Article> createArticle(Article article) {
        return CompletableFuture.supplyAsync(() -> articleRepository.save(article))
                .exceptionally(ex -> {
                    return null;
                });
    }

    @Override
    public CompletableFuture<List<Article>> getAllArticles() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Optional<Article>> getArticleById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Optional<Article>> updateArticle(Long id, Article articleDetails) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Boolean> deleteArticle(Long id) {
        throw new UnsupportedOperationException();
    }
} 