package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public interface PostListService {
    List<BaseIdxEntity> getAllPosts();
    Optional<BaseIdxEntity> getPostById(Long id);
}


