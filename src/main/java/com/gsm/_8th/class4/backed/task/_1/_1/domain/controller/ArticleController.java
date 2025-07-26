package com.gsm._8th.class4.backed.task._1._1.domain.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.DTO.ArticleDTO;
import com.gsm._8th.class4.backed.task._1._1.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<String> posting(@RequestBody ArticleDTO dto) {
        articleService.savePost(dto);
        return ResponseEntity.status(201).body("Article 리소스 생성에 성공함");
    }


    @GetMapping
    public ResponseEntity<List<ArticleDTO>> read() {
        List<ArticleDTO> list = articleService.findList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<ArticleDTO> reading(@PathVariable Long idx) {
        ArticleDTO post = articleService.readPost(idx);
        return ResponseEntity.ok(post);
    }

    @PatchMapping("/{idx}")
    public ResponseEntity<String> sujeong(
            @PathVariable Long idx,
            @RequestBody ArticleDTO dto) {
        articleService.sujeong(idx, dto);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<String> deleteByTitle(@PathVariable Long idx) {
        articleService.sakjeByTitle(idx);
        return ResponseEntity.noContent().build();
    }
}

