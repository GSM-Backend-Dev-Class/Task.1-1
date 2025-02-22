package com.gsm._8th.class4.backed.task._1._1.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.service.ArticleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
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
    @Async
    public CompletableFuture<Optional<Article>> getArticleById(Long id) {
        return CompletableFuture.supplyAsync(() -> articleRepository.findById(id))
                .exceptionally(ex -> {
                    return Optional.empty();
                });
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
    @Async
    public CompletableFuture<Boolean> deleteArticle(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Article> article = articleRepository.findById(id);
            article.ifPresent(articleRepository::delete);
            return article.isPresent();
        })
                .exceptionally(ex -> {
                    return false;
                });
    }
} 