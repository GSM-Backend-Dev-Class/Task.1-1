package com.gsm._8th.class4.backed.task._1._1.global.service.impl;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostUpdateServiceImpl implements PostUpdateService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Optional<BaseIdxEntity> updatePost(Long id, BaseIdxEntity post) {
        return postRepository.findById(id).map(existingPost -> {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setAuthor(post.getAuthor());
            return existingPost;
        });
    }
}
