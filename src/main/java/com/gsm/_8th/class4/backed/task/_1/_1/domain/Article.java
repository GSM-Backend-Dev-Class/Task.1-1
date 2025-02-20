package com.gsm._8th.class4.backed.task._1._1.domain;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article extends BaseIdxEntity {
    private String title;
    private String content;
} 