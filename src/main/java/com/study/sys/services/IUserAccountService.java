package com.study.sys.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.sys.models.UserAccountModel;
import com.study.sys.dtos.LoginDto;
import com.study.sys.dtos.UserDto;

public interface IUserAccountService extends IBaseService<String, UserAccountModel> {
	/**
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	UserDto login(LoginDto request) throws Exception;

	/**
	 *
	 * @param userName
	 * @throws Exception
	 */
	void logout(String userName) throws Exception;
}
