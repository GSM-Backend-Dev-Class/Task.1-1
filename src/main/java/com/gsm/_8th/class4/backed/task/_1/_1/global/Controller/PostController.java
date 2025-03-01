package com.gsm._8th.class4.backed.task._1._1.global.Controller;

import com.gsm._8th.class4.backed.task._1._1.global.entity.BaseIdxEntity;
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

    @GetMapping
    public ResponseEntity<List<BaseIdxEntity>> getAllPosts() {
        return ResponseEntity.ok(postListService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseIdxEntity> getPostById(@PathVariable Long id) {
        return postListService.getPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BaseIdxEntity> createPost(@RequestBody BaseIdxEntity post) {
        return ResponseEntity.ok(postCreateService.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseIdxEntity> updatePost(@PathVariable Long id, @RequestBody BaseIdxEntity post) {
        return postUpdateService.updatePost(id, post)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (!postDeleteService.deletePost(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
