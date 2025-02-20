package com.gsm._8th.class4.backed.task._1._1.global.repository;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
