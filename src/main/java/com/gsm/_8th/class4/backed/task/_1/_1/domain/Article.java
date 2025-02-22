package com.gsm._8th.class4.backed.task._1._1.domain;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "articles")
public class Article extends BaseIdxEntity {
    private String title;
    private String content;
    
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}