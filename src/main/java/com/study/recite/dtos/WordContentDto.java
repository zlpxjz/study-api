package com.study.recite.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class WordContentDto {
    private String  category;
    private String  subCategory;
    private String  content1;
    private String  content2;
    private String  content3;
}
