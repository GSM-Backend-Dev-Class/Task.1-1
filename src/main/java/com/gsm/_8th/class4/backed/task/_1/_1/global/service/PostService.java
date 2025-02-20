package com.gsm._8th.class4.backed.task._1._1.global.service;

import com.gsm._8th.class4.backed.task._1._1.global.entity.Post;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 모든 게시글 조회 (빈 리스트 반환)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 게시글 조회
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글 생성
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // 게시글 수정 (Optional로 변경하여 예외 처리 가능)
    @Transactional
    public Optional<Post> updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.update(postDetails.getTitle(), postDetails.getContent(), postDetails.getAuthor());
            return post;
        });
    }

    // 게시글 삭제 (존재 여부 확인)
    public boolean deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            return false; // 존재하지 않는 경우
        }
        postRepository.deleteById(id);
        return true;
    }
}
