package com.study.sys.services.impl;

import com.study.common.BaseServiceImpl;
import com.study.sys.models.UserModel;
import com.study.sys.mappers.UserMapper;
import com.study.sys.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("UserProfileService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<String, UserModel, UserMapper> implements IUserService {

}
