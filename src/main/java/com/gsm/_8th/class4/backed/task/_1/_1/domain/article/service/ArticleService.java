package com.gsm._8th.class4.backed.task._1._1.domain.article.service;

import com.gsm._8th.class4.backed.task._1._1.domain.article.dto.ArticleInfoDTO;
import com.gsm._8th.class4.backed.task._1._1.domain.article.entity.ArticleEntity;
import com.gsm._8th.class4.backed.task._1._1.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    // 전체 열람
    public List<ArticleEntity> getArticles() {
        List<ArticleEntity> articleList = articleRepository.findAll();
        return articleList;
    }

    // 열람
    public ArticleEntity viewArticle(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 게시
    public void postArticle(ArticleInfoDTO articleInfoDTO) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle(articleInfoDTO.getTitle());
        articleEntity.setContent(articleInfoDTO.getLore());
        articleRepository.save(articleEntity);
    }

    // 수정
    public void editArticle(Long id, ArticleInfoDTO articleInfoDTO) {
        ArticleEntity articleEntity = articleRepository.findById(id).orElse(null);
        articleEntity.setTitle(articleInfoDTO.getTitle());
        articleEntity.setContent(articleInfoDTO.getLore());
        articleRepository.save(articleEntity);
    }
}