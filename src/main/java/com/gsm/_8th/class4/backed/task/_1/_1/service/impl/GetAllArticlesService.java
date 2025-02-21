package com.gsm._8th.class4.backed.task._1._1.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Optional;

@Service
public class GetAllArticlesService implements ArticleService {

    private final ArticleRepository articleRepository;

    public GetAllArticlesService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Async
    public CompletableFuture<List<Article>> getAllArticles() {
        return CompletableFuture.supplyAsync(() -> articleRepository.findAll())
                .exceptionally(ex -> {
                    return List.of();
                });
    }

    @Override
    public CompletableFuture<Optional<Article>> getArticleById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Article> createArticle(Article article) {
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