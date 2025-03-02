package com.gsm._8th.class4.backed.task._1._1.global.Controller;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import com.gsm._8th.class4.backed.task._1._1.global.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostListService postListService;
    private final PostCreateService postCreateService;
    private final PostUpdateService postUpdateService;
    private final PostDeleteService postDeleteService;

    // 모든 게시글 조회
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() { // ✅ BaseIdxEntity → Post로 변경
        return ResponseEntity.ok(postListService.getAllPosts());
    }

    // 특정 게시글 조회
    @GetMapping("/{idx}") // ✅ id → idx 변경
    public ResponseEntity<Post> getPostById(@PathVariable Long idx) {
        return postListService.getPostById(idx)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postCreateService.createPost(post));
    }

    // 게시글 수정
    @PutMapping("/{idx}") // ✅ id → idx 변경
    public ResponseEntity<Post> updatePost(@PathVariable Long idx, @RequestBody Post post) {
        return postUpdateService.updatePost(idx, post)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 게시글 삭제
    @DeleteMapping("/{idx}") // ✅ id → idx 변경
    public ResponseEntity<Void> deletePost(@PathVariable Long idx) {
        if (!postDeleteService.deletePost(idx)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
