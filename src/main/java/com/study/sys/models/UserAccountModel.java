package com.study.sys.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/8.
 */

@Data
@Entity(name = "UserAccount")
@Table(name= "t_user_account_info")
public class UserAccountModel extends BaseModel<String>{
	@Column(name="user_name", columnDefinition = "varchar(32) not null comment '访问账号'")
	private String userName;

	@Column(name="password", columnDefinition = "varchar(32) not null comment '访问密码'")
	private String password;

	@Column(name="token", columnDefinition = "varchar(32) not null comment '访问令牌'")
	private String token;
}