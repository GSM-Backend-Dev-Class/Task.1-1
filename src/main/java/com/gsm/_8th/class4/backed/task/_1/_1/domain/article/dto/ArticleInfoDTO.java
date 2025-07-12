package com.gsm._8th.class4.backed.task._1._1.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleInfoDTO {
    @NotNull
    private String title;
    @NotNull
    private String lore;
}
