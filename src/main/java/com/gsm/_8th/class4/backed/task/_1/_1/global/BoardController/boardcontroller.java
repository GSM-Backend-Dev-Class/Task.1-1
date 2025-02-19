package com.gsm._8th.class4.backed.task._1._1.global.BoardController;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Article;
import com.gsm._8th.class4.backed.task._1._1.global.service.service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class boardcontroller {

    private final service Service;
    private final com.gsm._8th.class4.backed.task._1._1.global.Repositroy.bordRespository bordRespository;

    //게시물 조회
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles(){
        return Service.getArticles();
    }

    //특정 게시물 조회
    @GetMapping("/{articlesid}")
    public ResponseEntity<Article> getArticlesById(@PathVariable Long id){
        return Service.getArticlesById(id);
    }

    //게시물 삭제
    @DeleteMapping("/{articlesid}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
        if(bordRespository.existsById(id)){
            bordRespository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //게시물 수정
    @PatchMapping("/{articlesid}")
    public ResponseEntity<Article> updateArticles(@PathVariable Long id, @RequestBody Article article) {
        return Service.updateArticles(id,article.getTitle(),article.getContent());
    }

    @PostMapping("/articels")
    public ResponseEntity<Article> creatArticles(@RequestBody Article article){
        return Service.creatArticles(article.getTitle(), article.getContent());
    }
}

