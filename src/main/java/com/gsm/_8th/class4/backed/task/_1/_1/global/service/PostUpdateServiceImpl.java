package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostUpdateServiceImpl implements PostUpdateService {
    private final PostRepository postRepository;

    @Override
    public Optional<Post> updatePost(Long idx, Post postDetails) {
        return postRepository.findById(idx).map(post -> {
            post.updatePost(postDetails.getTitle(), postDetails.getContent(), postDetails.getAuthor());
            return post;
        });
    }
}
