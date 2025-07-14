package com.gsm._8th.class4.backed.task._1._1.domain.article.repository;

import com.gsm._8th.class4.backed.task._1._1.domain.article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}