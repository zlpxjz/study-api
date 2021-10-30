package com.study.recite.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Tony on 2021/10/22.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ReciteClockin")
@Table(name= "t_en_recite_clockin_info")
public class ReciteClockinModel extends BaseModel<String> {
	@Column(name="user_id", columnDefinition = "varchar(32) not null comment '用户ID'")
	private String userId;

	@Column(name="plan_id", columnDefinition = "varchar(32) not null comment '学习ID'")
	private String planId;

	@Column(name="book_id", columnDefinition = "varchar(32) not null comment '打卡书本'")
	private String bookId;

	@Column(name="first_word_id", columnDefinition = "varchar(32) not null comment '开始词汇ID'")
	private String firstWordId;

	@Column(name="last_word_id", columnDefinition = "varchar(32) not null comment '结束词汇ID'")
	private String lastWordId;

	@Column(name="word_num", columnDefinition = "Integer(11) not null comment '词汇数量'")
	private Integer wordNum;

	@Column(name="first_phrase_id", columnDefinition = "Integer(11) not null comment '开始短语ID'")
	private String firstPhraseId;

	@Column(name="last_phrase_id", columnDefinition = "Integer(11) not null comment '结束短语ID'")
	private String lastPhraseId;

	@Column(name="phrase_num", columnDefinition = "Integer(11) not null comment '短语数量'")
	private Integer phraseNum;

	@Column(name="clockin_date", columnDefinition = "timestamp default current_timestamp comment '打卡日期'")
	private Date clockinDate;
}
