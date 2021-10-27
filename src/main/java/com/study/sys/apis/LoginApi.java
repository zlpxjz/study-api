package com.study.sys.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.study.sys.services.IUserService;
import com.study.sys.dtos.LoginRequest;
import com.study.sys.dtos.LoginResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tony on 2021/10/25.
 */
@RestController
@Slf4j
@Api("Login相关API")
public class LoginApi {
	@Autowired
	private IUserService userService;

	@RequestMapping(path="/login")
	public ApiResponse login(@RequestBody LoginRequest loginRequest) throws Exception{
		LoginResponse response = userService.login(loginRequest);
		return ApiResponse.success(response);
	}

	@RequestMapping(path="/logout")
	public ApiResponse logout() throws Exception{
		return ApiResponse.success();
	}
}