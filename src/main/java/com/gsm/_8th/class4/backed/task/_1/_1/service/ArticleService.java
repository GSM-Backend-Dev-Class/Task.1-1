package com.gsm._8th.class4.backed.task._1._1.service;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import com.gsm._8th.class4.backed.task._1._1.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Cacheable("articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Optional<Article> updateArticle(Long id, Article articleDetails) {
        return articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.setTitle(articleDetails.getTitle());
                    existingArticle.setContent(articleDetails.getContent());
                    return articleRepository.save(existingArticle);
                });
    }

    public boolean deleteArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        article.ifPresent(articleRepository::delete);
        return article.isPresent();
    }
} 