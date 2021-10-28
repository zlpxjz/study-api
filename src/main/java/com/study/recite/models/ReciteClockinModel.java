package com.study.recite.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Tony on 2021/10/22.
 */

@Data
@Entity(name = "ReciteClickin")
@Table(name= "t_en_recite_clockin_info")
public class ReciteClockinModel extends BaseModel<String> {
	@Column(name="user_id", columnDefinition = "varchar(32) not null comment '用户ID'")
	private String userId;

	@Column(name="book_id", columnDefinition = "varchar(32) not null comment '打卡书本'")
	private String bookId;

	@Column(name="word_id", columnDefinition = "varchar(32) not null comment '打卡开始词汇ID'")
	private String wordId;

	@Column(name="word_num", columnDefinition = "Integer(11) not null comment '打卡词汇数量'")
	private Integer wordNum;

	@Column(name="phrase_id", columnDefinition = "Integer(11) not null comment '打卡开始短语ID'")
	private Integer phraseId;

	@Column(name="phrase_num", columnDefinition = "Integer(11) not null comment '打卡短语数量'")
	private Integer phraseNum;

	@Column(name="dictation_id", columnDefinition = "Integer(11) not null comment '打卡开始默写ID'")
	private Integer dictationId;

	@Column(name="dictation_num", columnDefinition = "Integer(11) not null comment '打卡默写数量'")
	private Integer dictationNum;

	@Column(name="dictation_right_num", columnDefinition = "Integer(11) not null comment '打卡默写正确数量'")
	private Integer dictationRightNum;

	@Column(name="dictation_wrong_num", columnDefinition = "Integer(11) not null comment '打卡默写错误数量'")
	private Integer dictationWrongNum;

	@Column(name="clockin_date", columnDefinition = "timestamp default current_timestamp comment '打卡日期'")
	private Date clockinDate;
}
