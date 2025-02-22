package com.gsm._8th.class4.backed.task._1._1.service;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ArticleService {

    CompletableFuture<List<Article>> getAllArticles();

    CompletableFuture<Optional<Article>> getArticleById(Long id);

    CompletableFuture<Article> createArticle(Article article);

    CompletableFuture<Optional<Article>> updateArticle(Long id, Article articleDetails);

    CompletableFuture<Boolean> deleteArticle(Long id);
} 
