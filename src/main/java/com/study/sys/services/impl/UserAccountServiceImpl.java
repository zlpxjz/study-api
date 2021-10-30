package com.study.sys.services.impl;

import com.fasterapp.base.AppException;
import com.fasterapp.base.utils.SecurityUtil;
import com.fasterapp.base.utils.StringUtil;
import com.study.common.BaseServiceImpl;
import com.study.sys.dtos.convertors.UserConvertor;
import com.study.sys.mappers.UserAccountMapper;
import com.study.sys.models.UserAccountModel;
import com.study.sys.models.UserModel;
import com.study.sys.services.IUserAccountService;
import com.study.sys.dtos.LoginDto;
import com.study.sys.dtos.UserDto;
import com.study.sys.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserAccountServiceImpl extends BaseServiceImpl<String, UserAccountModel, UserAccountMapper> implements IUserAccountService {
	@Autowired
	private IUserService userService;

	@Override
	public void register(UserDto userDto) throws Exception {
		UserAccountModel userAccountModel = super.mapper.selectByUserName(userDto.getUserName());
		if(userAccountModel != null){
			throw new AppException("账号已存在。");
		}

		if(! SecurityUtil.checkStrength(userDto.getPassword())){
			throw new AppException("密码强度不够。密码至少：长度不能短于8，且包含大写字母.");
		}

		userAccountModel = new UserAccountModel();
		userAccountModel.setUserName(userDto.getUserName());
		userAccountModel.setPassword(SecurityUtil.encrypt(userDto.getPassword()));
		userAccountModel.setToken(StringUtil.getUUID());
		this.save(userAccountModel);
	}

	@Override
	public void update(UserDto userDto) throws Exception {

	}

	@Override
	public void reset(UserDto userDto) throws Exception {

	}

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

		UserModel userModel = this.userService.getByAccount(userAccountModel.getId());
		userAccountModel.setPassword(null);
		return UserConvertor.INSTANCE.convert(userAccountModel, userModel);
	}

	@Override
	public void logout(String userName) throws Exception {

	}
}
