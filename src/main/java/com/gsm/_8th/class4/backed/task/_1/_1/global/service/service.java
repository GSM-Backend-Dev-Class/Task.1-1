package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.Repositroy.bordRespository;
import com.gsm._8th.class4.backed.task._1._1.global.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class service {
    private final bordRespository bordrespository;

    //게시물 조회
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = bordrespository.findAll();
        return ResponseEntity.ok(articles);
    }

    //특정 게시물 조회
    public ResponseEntity<Article> getArticlesById(Long id){
        Article article = bordrespository.findById(id).orElse(null);
        if (article != null){
            return ResponseEntity.ok(article);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //게시물 생성
    public ResponseEntity<Article> creatArticles(String title, String content){
        Article article = new Article(title,content);
        Article savearticle = bordrespository.save(article);
        return ResponseEntity.ok(savearticle);
    }

    //특정 게시물 수정(업데이트)
    public ResponseEntity<Article> updateArticles(Long id, String title, String content){
        Article article = bordrespository.findById(id).orElse(null);
        if(article != null){
            article.update(title,content);
            return ResponseEntity.ok(article);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //특정 게시물 삭제
    public ResponseEntity<Article> deleteArticle(Long id){
        if(bordrespository.existsById(id)){
            bordrespository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
