package com.study.recite.models;


import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "UserWord")
@Table(name= "t_user_word_info")
public class UserWordModel extends BaseModel<String> {
    @Column(name="word_id", columnDefinition = "varchar(32) not null comment '单词ID'")
    private String wordId;

    @Column(name="user_id", columnDefinition = "varchar(32) not null comment '用户ID'")
    private String userId;

    @Column(name="familiarity", columnDefinition = "char(1) not null comment '熟悉程度 1-5'")
    private String familiarity;

    @Column(name="is_wrong", columnDefinition = "char(1) not null comment '是否默写错误 Y/N'")
    private String wrong;

    @Column(name="is_favorited", columnDefinition = "char(1) not null comment '是否收藏 Y/N'")
    private String favorited;
}
