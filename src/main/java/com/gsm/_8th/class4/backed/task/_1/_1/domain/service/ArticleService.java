package com.gsm._8th.class4.backed.task._1._1.domain.service;

import com.gsm._8th.class4.backed.task._1._1.domain.DTO.ArticleDTO;
import com.gsm._8th.class4.backed.task._1._1.domain.entity.ArticleEntity;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void savePost(ArticleDTO ArticleDTO) {
        ArticleEntity articleEntity = ArticleEntity.builder()
                .title(ArticleDTO.getTitle())
                .content(ArticleDTO.getContent())
                .build();
        articleRepository.save(articleEntity);
    }

    public List<ArticleDTO> findList() {
        List<ArticleEntity> posts = articleRepository.findAll();
        if (posts.isEmpty()) {
            return Collections.emptyList(); //  데이터가 없으면 200 OK + 빈 리스트([]) 반환
        }
        return posts.stream()
                .map(post -> new ArticleDTO(
                        post.getIdx(),
                        post.getTitle(),
                        post.getContent(),
                        post.getCreatedAt(),
                        post.getUpdatedAt()
                ))
                .collect(Collectors.toList());
    }

    public ArticleDTO readPost(Long idx) {
        ArticleEntity post = articleRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        return new ArticleDTO(
                post.getIdx(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public void sujeong(Long idx, ArticleDTO dto) {
        ArticleEntity post = articleRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        articleRepository.save(post);
    }

    public void sakjeByTitle(Long idx) {
        ArticleEntity post = articleRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        articleRepository.delete(post);
    }




}

