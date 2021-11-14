package com.study.recite.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReciteClockinDto {
    private String clockinId;
    private String planId;
    private String bookId;
    private Integer wordNum;
    private Integer phraseNum;
    private Integer clockinNum;
    private Date clockinDate;
    private List<WordDto> words;
}
