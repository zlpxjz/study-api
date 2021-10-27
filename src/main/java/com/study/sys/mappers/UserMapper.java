package com.study.sys.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.sys.models.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<Integer, UserModel> {
	UserModel selectByUserName(@Param("userName") String userName);
}

