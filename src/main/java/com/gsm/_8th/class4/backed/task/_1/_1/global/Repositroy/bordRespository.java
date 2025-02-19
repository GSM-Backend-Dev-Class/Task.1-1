package com.gsm._8th.class4.backed.task._1._1.global.Repositroy;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bordRespository extends JpaRepository<Article, Long> {
}
