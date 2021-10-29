package com.study.recite.mappers;


import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.models.ReciteClockinModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReciteClockinMapper extends BaseMapper<String, ReciteClockinModel> {
	List<ReciteClockinModel> selectByUserAndPlan(@Param("userId") String userId, @Param("planId") String planId);
}

