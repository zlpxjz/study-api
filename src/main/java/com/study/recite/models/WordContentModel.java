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
@Entity(name = "WordContent")
@Table(name= "t_en_word_content_info")
public class WordContentModel extends BaseModel<String> {
	@Column(name="word_id", columnDefinition = "varchar(32) not null comment '单词'")
	private String wordId;

	@Column(name="category", columnDefinition = "varchar(16) not null comment '大类。音标、释义、词组短语、同近义词、同根词、词语辨析、双语例句'")
	private String  category;

	@Column(name="sub_category", columnDefinition = "varchar(16) not null comment '类型:词汇/短语'")
	private String  subCategory;

	@Column(name="content_1", columnDefinition = "varchar(512) not null comment '内容1'")
	private String  content1;

	@Column(name="content_2", columnDefinition = "varchar(512) not null comment '内容2'")
	private String  content2;

	@Column(name="content_3", columnDefinition = "varchar(512) not null comment '内容3'")
	private String  content3;
}
