package com.gsm._8th.class4.backed.task._1._1.domain.article.dto;

import java.time.LocalDateTime;

public record ArticleResponse(
        Long idx,
        String title,
        String content,
        LocalDateTime created_at,
        LocalDateTime updated_at
) {}