package com.study.sys.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * Created by Tony on 2021/10/27.
 */
@Data
public class UserDto {
	private String 	userName;
	private String  password;
	private String 	token;

	private String  nickName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date	loginTime;
}
