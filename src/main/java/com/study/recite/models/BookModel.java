package com.study.recite.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/22.
 */

@Data
@Entity(name = "Book")
@Table(name= "t_book_info")
public class BookModel extends BaseModel<Integer> {
	@Column(name="parent_id", columnDefinition = "Integer(11) not null comment '关联书本'")
	private Integer parentId;

	@Column(name="phase", columnDefinition = "varchar(32) not null comment '阶段。小学、初中、高中'")
	private String phase;

	@Column(name="grade", columnDefinition = "varchar(32) not null comment '年级。'")
	private String grade;

	@Column(name="course", columnDefinition = "varchar(32) not null comment '课程'")
	private String  course;

	@Column(name="category", columnDefinition = "varchar(32) not null comment '分类'")
	private String  category;

	@Column(name="name", columnDefinition = "varchar(32) not null comment '书名'")
	private String  name;

	@Column(name="cover_pic", columnDefinition = "varchar(32) not null comment '封面'")
	private String coverPic;
}
