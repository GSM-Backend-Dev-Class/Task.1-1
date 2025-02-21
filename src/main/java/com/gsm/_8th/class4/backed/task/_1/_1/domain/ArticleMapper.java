package com.gsm._8th.class4.backed.task._1._1.domain;

public class ArticleMapper {
    public static ArticleDTO toDTO(Article article) {
        return new ArticleDTO(article.getTitle(), article.getContent());
    }

    public static Article toEntity(ArticleDTO articleDTO) {
        return Article.builder()
                .title(articleDTO.getTitle())
                .content(articleDTO.getContent())
                .build();
    }
} 