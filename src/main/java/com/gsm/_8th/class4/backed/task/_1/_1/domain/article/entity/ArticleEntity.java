package com.gsm._8th.class4.backed.task._1._1.domain.article.entity;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "article")
public class ArticleEntity extends BaseIdxEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}