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
@Entity(name = "RecitePlan")
@Table(name= "t_en_recite_plan_info")
public class RecitePlanModel extends BaseModel<String> {
	public static enum RECITE_STATUS{
		未开始,进行中,暂停中,已结束
	}

	@Column(name="book_id", columnDefinition = "varchar(32) not null comment '关联书本'")
	private String bookId;

	@Column(name="user_id", columnDefinition = "varchar(32) not null comment '用户ID'")
	private String userId;

	@Column(name="plan_word_num", columnDefinition = "Integer(11) not null comment '计划词汇数量'")
	private Integer planWordNum;

	@Column(name="plan_phrase_num", columnDefinition = "Integer(11) not null comment '计划短语数量'")
	private Integer planPhraseNum;

	@Column(name="total_word_num", columnDefinition = "Integer(11) not null comment '词汇总数量'")
	private Integer totalWordNum;

	@Column(name="total_phrase_num", columnDefinition = "Integer(11) not null comment '短语总数量'")
	private Integer totalPhraseNum;

	@Column(name="recited_word_num", columnDefinition = "Integer(11) not null comment '已背诵词汇数量'")
	private Integer recitedWordNum;

	@Column(name="recited_phrase_num", columnDefinition = "Integer(11) not null comment '已背诵短语数量'")
	private Integer recitedPhraseNum;

	@Column(name="repeat_times", columnDefinition = "Integer(11) not null comment '重复次数'")
	private Integer repeatTimes;

	@Column(name="clockin_id", columnDefinition = "varchar(32) not null comment '最新打卡记录")
	private String clockinId;

	@Column(name="clockin_times", columnDefinition = "Integer(11) not null comment '打卡次数")
	private Integer clockinTimes;

	@Column(name="recite_status", columnDefinition = "varchar(8) not null comment '背诵状态：未开始/进行中/已结束")
	private String reciteStatus;
}
