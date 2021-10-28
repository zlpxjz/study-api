package com.study.sys.dtos;

import com.fasterapp.base.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.sys.models.UserAccountModel;
import lombok.Getter;

import java.util.Date;

/**
 * Created by Tony on 2021/10/27.
 */
@Getter
public class UserDto {
	private String 	userName;
	private String 	token;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date	loginTime;

	public static UserDto build(UserAccountModel userAccountModel){
		UserDto response = new UserDto();

		response.userName = userAccountModel.getUserName();
		response.token = userAccountModel.getToken();
		response.loginTime = DateUtil.getSysDate();

		return response;
	}
}
