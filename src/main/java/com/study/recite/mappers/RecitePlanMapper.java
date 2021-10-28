package com.study.recite.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.models.RecitePlanModel;

import java.util.Map;

public interface RecitePlanMapper extends BaseMapper<String, RecitePlanModel> {
	RecitePlanModel selectByMap(Map params);
}

