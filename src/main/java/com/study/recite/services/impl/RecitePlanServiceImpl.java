package com.study.recite.services.impl;

import com.study.common.BaseServiceImpl;
import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.dtos.convertors.RecitePlanConvertor;
import com.study.recite.mappers.RecitePlanMapper;
import com.study.recite.models.BookModel;
import com.study.recite.models.RecitePlanModel;
import com.study.recite.services.IBookService;
import com.study.recite.services.IRecitePlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("RecitePlanService")
@Transactional(rollbackFor = Exception.class)
public class RecitePlanServiceImpl extends BaseServiceImpl<String, RecitePlanModel, RecitePlanMapper> implements IRecitePlanService {
	@Autowired
	private IBookService bookService;

	@Override
	public void save(RecitePlanDto planDto) throws Exception {
		String id = planDto.getId();

		RecitePlanModel planModel = null;
		if(id == null){
			planModel = new RecitePlanModel();
		}else{
			planModel = super.mapper.selectByPrimaryKey(id);
		}

		planModel.setPlanPhraseNum(planDto.getPlanPhraseNum());
		planModel.setPlanWordNum(planDto.getPlanWordNum());
		planModel.setRepeatTimes(planDto.getRepeatTimes());

		super.save(planModel);
	}

	@Override
	public RecitePlanModel getModel(String userId) throws Exception {
		Map params = new HashMap<>();
		params.put("userId", userId);
		params.put("status", RecitePlanModel.RECITE_STATUS.进行中.name());
		return this.mapper.selectByMap(params);
	}

	@Override
	public RecitePlanDto get(String userId) throws Exception {
		Map params = new HashMap<>();
		params.put("userId", userId);
		params.put("status", RecitePlanModel.RECITE_STATUS.进行中.name());
		RecitePlanModel planModel = this.mapper.selectByMap(params);
		if(planModel == null){
			return null;
		}

		BookModel bookModel = bookService.getOne(planModel.getBookId());

		return RecitePlanConvertor.INSTANCE.convert(planModel, bookModel);
	}
}
