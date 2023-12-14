package com.ll.medium.domain.post.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String body;
    private boolean isPublished;
}
