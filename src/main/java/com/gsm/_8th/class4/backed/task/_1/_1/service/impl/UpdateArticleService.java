package com.gsm._8th.class4.backed.task._1._1.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.List;

@Service
public class UpdateArticleService implements ArticleService {

    private final ArticleRepository articleRepository;

    public UpdateArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Async
    public CompletableFuture<Optional<Article>> updateArticle(Long id, Article articleDetails) {
        return CompletableFuture.supplyAsync(() -> articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.update(articleDetails.getTitle(), articleDetails.getContent());
                    return articleRepository.save(existingArticle);
                }))
                .exceptionally(ex -> {
                    return Optional.empty();
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
    public CompletableFuture<Article> createArticle(Article article) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Boolean> deleteArticle(Long id) {
        throw new UnsupportedOperationException();
    }
} 