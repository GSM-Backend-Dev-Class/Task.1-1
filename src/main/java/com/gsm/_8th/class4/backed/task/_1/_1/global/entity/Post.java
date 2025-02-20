package com.gsm._8th.class4.backed.task._1._1.global.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;

@Entity
@Getter
@Setter  // 필드 값을 수정할 수 있도록 추가
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post extends BaseIdxEntity {

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, length = 100)
    private String author;

    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public ResponseEntity<Object> map(Object o) {
        return ResponseEntity.ok(o);
    }

}
