package com.study.sys.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.sys.models.UserAccountModel;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper extends BaseMapper<String, UserAccountModel> {
	UserAccountModel selectByUserName(@Param("userName") String userName);
}

