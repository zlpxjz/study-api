package com.study.recite.services.impl;

import com.fasterapp.base.arch.service.BaseServiceImpl;
import com.study.recite.mappers.ReciteClockinMapper;
import com.study.recite.models.ReciteClockinModel;
import com.study.recite.services.IReciteClockinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("ReciteClickinService")
@Transactional(rollbackFor = Exception.class)
public class ReciteClockinServiceImpl extends BaseServiceImpl<String, ReciteClockinModel, ReciteClockinMapper> implements IReciteClockinService {
	@Override
	public List<ReciteClockinModel> get(String userId, String planId) throws Exception {
		return this.mapper.selectByUserAndPlan(userId, planId);
	}
}
