package com.study.sys.dtos;

import lombok.Data;

/**
 * Created by Tony on 2021/10/25.
 */
@Data
public class LoginRequest {
	private String userName;
	private String password;
}
