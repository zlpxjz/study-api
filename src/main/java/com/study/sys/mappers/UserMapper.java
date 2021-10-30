package com.study.sys.mappers;

import com.study.sys.models.UserModel;

import com.fasterapp.base.arch.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<String, UserModel> {
    UserModel selectByAccount(@Param("accountId") String accountId);
}

