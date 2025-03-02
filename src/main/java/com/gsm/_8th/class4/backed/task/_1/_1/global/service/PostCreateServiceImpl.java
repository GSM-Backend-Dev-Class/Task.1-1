package com.gsm._8th.class4.backed.task._1._1.global.service.impl;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCreateServiceImpl implements PostCreateService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
