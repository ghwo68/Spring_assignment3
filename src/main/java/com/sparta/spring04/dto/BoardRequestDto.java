package com.sparta.spring04.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
}
