package com.study.recite.mappers;

import com.study.recite.models.UserWordModel;

import com.fasterapp.base.arch.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWordMapper extends BaseMapper<String, UserWordModel> {
    UserWordModel selectByUserAndWord(@Param("userId") String userId, @Param("wordId") String wordId);

    List<UserWordModel> selectWrongWordByUser(@Param("userId") String userId);

    List<UserWordModel> selectFavoiteWordByUser(@Param("userId") String userId);
}


