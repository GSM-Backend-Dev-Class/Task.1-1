package com.gsm._8th.class4.backed.task._1._1.global.service.impl;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
import com.gsm._8th.class4.backed.task._1._1.global.repository.BaseIdxEntityRepository;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostListServiceImpl implements PostListService {
    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BaseIdxEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BaseIdxEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }
}
