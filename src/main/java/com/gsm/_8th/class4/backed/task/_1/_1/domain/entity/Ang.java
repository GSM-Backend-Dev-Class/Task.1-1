package com.gsm._8th.class4.backed.task._1._1.domain.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ang extends BaseIdxEntity{
    private String title;
    private String content;

    @Builder
    public Ang(Long idx, String title, String content){
        this.idx = idx;
        this.title = title;
        this.content = content;
    }
}
