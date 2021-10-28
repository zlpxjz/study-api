package com.study.sys.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/28.
 */
@Data
@Entity(name = "User")
@Table(name= "t_user_info")
public class UserModel extends BaseModel<String> {
	@Column(name="real_name", columnDefinition = "varchar(32) not null comment '实名'")
	private String realName;

	@Column(name="phone", columnDefinition = "varchar(16) comment '电话号码'")
	private String phone;

	@Column(name="email", columnDefinition = "varchar(16) comment 'Email地址'")
	private String email;

	@Column(name="user_id", columnDefinition = "varchar(32) not null comment '账户ID'")
	private String userId;
}
