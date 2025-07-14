package com.gsm._8th.class4.backed.task._1._1.domain.article.service;

import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleInfo;
import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleResponse;
import com.gsm._8th.class4.backed.task._1._1.domain.article.entity.ArticleEntity;
import com.gsm._8th.class4.backed.task._1._1.domain.article.repository.ArticleRepository;
import com.gsm._8th.class4.backed.task._1._1.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    // 전체 열람
    public List<ArticleResponse> getArticles() {
        return articleRepository.findAll().stream()
                .map(articleEntity -> new ArticleResponse(
                        articleEntity.getIdx(),
                        articleEntity.getTitle(),
                        articleEntity.getContent(),
                        articleEntity.getCreatedAt(),
                        articleEntity.getUpdatedAt()
                )).toList();
    }

    // 열람
    public ArticleResponse viewArticle(Long id) {
        ArticleEntity articleEntity = articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 아이디의 게시글이 존재하지 않습니다."));
        return new ArticleResponse(
                articleEntity.getIdx(),
                articleEntity.getTitle(),
                articleEntity.getContent(),
                articleEntity.getCreatedAt(),
                articleEntity.getUpdatedAt()
        );
    }

    // 게시
    public void postArticle(ArticleInfo articleInfo) {
        if(articleInfo.title() == null || articleInfo.content() == null) {
            throw new NullPointerException("제목이나 내용이 비어있으면 안됩니다.");
        }
        ArticleEntity articleEntity = ArticleEntity.builder()
                .title(articleInfo.title())
                .content(articleInfo.content())
                .build();
        articleRepository.save(articleEntity);
    }

    // 수정
    public void editArticle(Long id, ArticleInfo articleInfo) {
        ArticleEntity articleEntity = articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 아이디의 게시글이 존재하지 않습니다."));
        articleEntity.update(articleInfo.title(), articleInfo.content());
        articleRepository.save(articleEntity);
    }

    // 삭제
    public void deleteArticle(Long id) {
        articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 아이디의 게시글이 존재하지 않습니다."));
        articleRepository.deleteById(id);
    }
}