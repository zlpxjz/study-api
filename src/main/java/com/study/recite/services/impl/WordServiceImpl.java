package com.study.recite.services.impl;

import com.study.common.BaseServiceImpl;
import com.study.recite.mappers.WordMapper;
import com.study.recite.models.WordModel;
import com.study.recite.services.IWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("WordService")
@Transactional(rollbackFor = Exception.class)
public class WordServiceImpl extends BaseServiceImpl<String, WordModel, WordMapper> implements IWordService {

	@Override
	public List<WordModel> get(String bookId, String firstWordId, int size) throws Exception {
		return this.mapper.selectByBookAndFirstWordIdAndSize(bookId, firstWordId, size);
	}


	@Override
	public List<WordModel> get(List<String> wordIds) throws Exception {
		return this.mapper.selectByIds(wordIds);
	}
}
