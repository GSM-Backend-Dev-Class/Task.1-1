package com.gsm._8th.class4.backed.task._1._1.repository;

import com.gsm._8th.class4.backed.task._1._1.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
} 