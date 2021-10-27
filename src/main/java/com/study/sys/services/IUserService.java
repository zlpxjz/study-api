package com.study.sys.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.sys.models.UserModel;
import com.study.sys.dtos.LoginRequest;
import com.study.sys.dtos.LoginResponse;

public interface IUserService extends IBaseService<Integer, UserModel> {
	/**
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	LoginResponse login(LoginRequest request) throws Exception;

	/**
	 *
	 * @param userName
	 * @throws Exception
	 */
	void logout(String userName) throws Exception;
}
