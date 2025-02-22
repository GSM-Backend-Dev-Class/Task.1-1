package com.gsm._8th.class4.backed.task._1._1.dto;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;

public class ArticleRequestDTO {

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
} 