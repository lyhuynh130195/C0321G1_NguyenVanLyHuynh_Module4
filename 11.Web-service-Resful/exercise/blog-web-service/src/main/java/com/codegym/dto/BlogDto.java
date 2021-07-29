package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private int id;
    private String name;
    private String nameAuthor;
    private CategoryDto categoryDto;
    private String content;
    private String date;
}
