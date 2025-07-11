package com.gsm._8th.class4.backed.task._1._1.domain.article.entity;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "article")
public class ArticleEntity extends BaseIdxEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
}