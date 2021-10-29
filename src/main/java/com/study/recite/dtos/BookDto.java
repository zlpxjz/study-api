package com.study.recite.dtos;

import lombok.Data;

/**
 * Created by Tony on 2021/10/27.
 */
@Data
public class BookDto {
	private String id;
	private String parentId;
	private String phase;
	private String grade;
	private String course;
	private String category;
	private String name;
	private String coverPic;
}