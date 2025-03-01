package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
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
    public BaseIdxEntity createPost(BaseIdxEntity post) {
        return postRepository.save(post);
    }
}
