package com.study.sys.services.impl;

import com.fasterapp.base.AppException;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import com.fasterapp.base.utils.SecurityUtil;
import com.study.sys.mappers.UserMapper;
import com.study.sys.models.UserModel;
import com.study.sys.services.IUserService;
import com.study.sys.dtos.LoginRequest;
import com.study.sys.dtos.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<Integer, UserModel, UserMapper> implements IUserService {
	@Override
	public LoginResponse login(LoginRequest request) throws Exception {
		String userName = request.getUserName(), password = request.getPassword();

		UserModel userModel = super.mapper.selectByUserName(userName);
		if(userModel == null){
			throw new AppException("输入账号无效，请重新输入");
		}

		String encryptPwd = SecurityUtil.encrypt(password);
		if(! encryptPwd.equals(userModel.getPassword())){
			throw new AppException("输入账号无效，请重新输入");
		}

		return LoginResponse.build(userModel);
	}

	@Override
	public void logout(String userName) throws Exception {

	}


}
