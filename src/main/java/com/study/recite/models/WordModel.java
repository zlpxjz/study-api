package com.study.recite.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/22.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Word")
@Table(name= "t_en_word_info")
public class WordModel extends BaseModel<String> {
	@Column(name="word", columnDefinition = "varchar(64) not null comment '词汇'")
	private String  word;

	@Column(name="word_type", columnDefinition = "varchar(8) not null comment '类型:词汇/短语'")
	private String  wordType;

	@Column(name="importance", columnDefinition = "int(2) default 1 comment '重要性 1-5'")
	private Integer importance;
}
