package com.study.recite.dtos;

import lombok.Data;

/**
 * Created by Tony on 2021/10/27.
 */
@Data
public class GetBookDto {
	private String phase; //阶段
	private String grade; //等级
	private String course; //科目
	private String category; //内容分类（单词， 笔记）
}
