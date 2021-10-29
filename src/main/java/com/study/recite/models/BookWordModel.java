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
@Entity(name = "BookWord")
@Table(name= "t_en_book_word_info")
public class BookWordModel extends BaseModel<String> {
	@Column(name="book_id", columnDefinition = "varchar(32) not null comment '书本'")
	private String bookId;

	@Column(name="word_id", columnDefinition = "varchar(32) not null comment '词汇'")
	private String wordId;
}
