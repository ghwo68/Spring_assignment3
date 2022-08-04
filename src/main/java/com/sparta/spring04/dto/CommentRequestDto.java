package com.sparta.spring04.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private Long boardId;
    private String content;
}
