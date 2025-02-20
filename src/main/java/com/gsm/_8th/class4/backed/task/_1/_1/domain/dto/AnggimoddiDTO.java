package com.gsm._8th.class4.backed.task._1._1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AnggimoddiDTO {
    private Long id;
    private String title;
    private String content;
}
