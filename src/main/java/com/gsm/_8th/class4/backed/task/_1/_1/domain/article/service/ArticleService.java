package com.gsm._8th.class4.backed.task._1._1.domain.article.service;

import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleInfo;
import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleResponse;

import java.util.List;

public interface ArticleService {
    public List<ArticleResponse> getArticles();
    public ArticleResponse viewArticle(Long id);
    public void postArticle(ArticleInfo articleInfo);
    public void editArticle(Long id, ArticleInfo articleInfo);
    public void deleteArticle(Long id);
}
