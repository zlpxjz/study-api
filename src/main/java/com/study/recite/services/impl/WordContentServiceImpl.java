package com.study.recite.services.impl;

import com.study.recite.mappers.WordContentMapper;
import com.study.recite.models.WordContentModel;
import com.study.recite.services.IWordContentService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("WordContentService")
@Transactional(rollbackFor = Exception.class)
public class WordContentServiceImpl extends BaseServiceImpl<String, WordContentModel, WordContentMapper> implements IWordContentService {
	@Override
	public List<WordContentModel> get(List<String> wordIds) throws Exception {
		return null;
	}
}
