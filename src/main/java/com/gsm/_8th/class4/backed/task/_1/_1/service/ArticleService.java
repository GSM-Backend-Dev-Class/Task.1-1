package com.gsm._8th.class4.backed.task._1._1.service;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

import java.util.List;
import java.util.Optional;  
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Async
    @Cacheable("articles")
    public CompletableFuture<List<Article>> getAllArticles() {
        return CompletableFuture.supplyAsync(() -> articleRepository.findAll())
                .exceptionally(ex -> {
                    return List.of();
                });
    }

    @Async
    public CompletableFuture<Optional<Article>> getArticleById(@NotNull Long id) {
        return CompletableFuture.supplyAsync(() -> articleRepository.findById(id))
                .exceptionally(ex -> {
                    return Optional.empty();
                });
    }

    @Async
    public CompletableFuture<Article> createArticle(@Valid Article article) {
        return CompletableFuture.supplyAsync(() -> articleRepository.save(article))
                .exceptionally(ex -> {
                    return null;
                });
    }

    @Async
    public CompletableFuture<Optional<Article>> updateArticle(@NotNull Long id, @Valid Article articleDetails) {
        return CompletableFuture.supplyAsync(() -> articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.setTitle(articleDetails.getTitle());
                    existingArticle.setContent(articleDetails.getContent());
                    return articleRepository.save(existingArticle);
                }))
                .exceptionally(ex -> {
                    return Optional.empty();
                });
    }

    @Async
    public CompletableFuture<Boolean> deleteArticle(@NotNull Long id) {
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