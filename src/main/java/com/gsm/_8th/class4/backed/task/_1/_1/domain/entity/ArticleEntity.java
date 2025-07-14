package com.gsm._8th.class4.backed.task._1._1.domain.entity;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity extends BaseIdxEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
}

