package com.gsm._8th.class4.backed.task._1._1.global.service.impl;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostListServiceImpl implements PostListService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long idx) {
        return postRepository.findById(idx);
    }
}
