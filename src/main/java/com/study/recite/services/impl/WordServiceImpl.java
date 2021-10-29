package com.study.recite.services.impl;

import com.fasterapp.base.arch.service.BaseServiceImpl;
import com.fasterapp.base.utils.CollectionUtil;
import com.study.recite.dtos.WordDto;
import com.study.recite.dtos.convertors.WordConvertor;
import com.study.recite.mappers.WordMapper;
import com.study.recite.models.WordContentModel;
import com.study.recite.models.WordModel;
import com.study.recite.services.IWordContentService;
import com.study.recite.services.IWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("WordService")
@Transactional(rollbackFor = Exception.class)
public class WordServiceImpl extends BaseServiceImpl<String, WordModel, WordMapper> implements IWordService {
	@Autowired
	private IWordContentService wordContentService;

	@Override
	public List<WordDto> get(String bookId, String firstWordId, int size) throws Exception {
		List<WordDto> wordDtoList = new ArrayList<>();

		List<WordModel> wordModelList = this.mapper.selectByBookAndFirstWordIdAndSize(bookId, firstWordId, size);
		if(CollectionUtil.isNotEmpty(wordModelList)){
			Map<String, WordModel> wordModelMap = new HashMap<>();
			List<String> wordIds = new ArrayList<>();
			wordModelList.forEach(model -> {
				wordModelMap.put(model.getId(), model);
				wordIds.add(model.getId());
			});

			List<WordContentModel> wordContentModelList = wordContentService.get(wordIds);
			if(CollectionUtil.isNotEmpty(wordContentModelList)){
				List<WordContentModel> contentModelList = null;
				String wordId = null;
				for(WordContentModel wordContentModel : wordContentModelList){
					if(wordId != null && !wordContentModel.getId().equals(wordId)){
						wordDtoList.add(WordConvertor.INSTANCE.convert(wordModelMap.get(wordId), contentModelList));
						wordId = wordContentModel.getWordId();
						contentModelList.clear();
					}

					contentModelList.add(wordContentModel);
				}

				if(CollectionUtil.isNotEmpty(contentModelList)) {
					wordDtoList.add(WordConvertor.INSTANCE.convert(wordModelMap.get(wordId), contentModelList));
				}
			}
		}

		return wordDtoList;
	}
}
