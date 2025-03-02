package com.gsm._8th.class4.backed.task._1._1.global.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post extends BaseIdxEntity { // ✅ BaseIdxEntity 상속

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;

    // 📌 값 변경을 위한 메서드 (setter 대신 사용)
    public void updatePost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
