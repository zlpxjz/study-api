package com.study.sys.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/28.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "User")
@Table(name= "t_user_info")
public class UserModel extends BaseModel<String> {
	@Column(name="real_name", columnDefinition = "varchar(32) not null comment '实名'")
	private String realName;

	@Column(name="nick_name", columnDefinition = "varchar(32) not null comment '昵称'")
	private String nickName;

	@Column(name="phone", columnDefinition = "varchar(16) comment '电话号码'")
	private String phone;

	@Column(name="email", columnDefinition = "varchar(16) comment 'Email地址'")
	private String email;

	@Column(name="sex", columnDefinition = "varchar(8) comment '性别 男/女'")
	private String sex;

	@Column(name="birthday", columnDefinition = "varchar(10) comment '生日 yyyy-mm-dd'")
	private String birthday;

	@Column(name="account_id", columnDefinition = "varchar(32) not null comment '账户ID'")
	private String accountId;

	@Column(name="portrait", columnDefinition = "varchar(64) comment 'ICON图片'")
	private String portrait;
}
