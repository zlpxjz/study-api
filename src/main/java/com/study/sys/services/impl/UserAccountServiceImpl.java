package com.study.sys.services.impl;

import com.fasterapp.base.AppException;
import com.fasterapp.base.utils.SecurityUtil;
import com.study.common.BaseServiceImpl;
import com.study.sys.mappers.UserAccountMapper;
import com.study.sys.models.UserAccountModel;
import com.study.sys.services.IUserAccountService;
import com.study.sys.dtos.LoginDto;
import com.study.sys.dtos.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserAccountServiceImpl extends BaseServiceImpl<String, UserAccountModel, UserAccountMapper> implements IUserAccountService {
	@Override
	public UserDto login(LoginDto request) throws Exception {
		String userName = request.getUserName(), password = request.getPassword();

		UserAccountModel userAccountModel = super.mapper.selectByUserName(userName);
		if(userAccountModel == null){
			throw new AppException("输入账号无效，请重新输入");
		}

		String encryptPwd = SecurityUtil.encrypt(password);
		if(! encryptPwd.equals(userAccountModel.getPassword())){
			throw new AppException("输入账号无效，请重新输入");
		}

		return UserDto.build(userAccountModel);
	}

	@Override
	public void logout(String userName) throws Exception {

	}


}
