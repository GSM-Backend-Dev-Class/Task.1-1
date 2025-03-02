package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostListService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long idx);
}
