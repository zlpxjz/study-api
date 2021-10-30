package com.study.recite.services.impl;

import com.fasterapp.base.AppException;
import com.fasterapp.base.utils.CollectionUtil;
import com.fasterapp.base.utils.DateUtil;
import com.fasterapp.base.utils.StringUtil;
import com.study.recite.dtos.WordDto;
import com.study.recite.dtos.convertors.WordConvertor;
import com.study.recite.models.*;
import com.study.recite.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2021/10/29.
 */
@Slf4j
@Service("ReciteService")
public class ReciteServiceImpl implements IReciteService {
	@Autowired
	private IRecitePlanService recitePlanService;

	@Autowired
	private IReciteClockinService reciteClockinService;

	@Autowired
	private IWordService wordService;

	@Autowired
	private IUserWordService userWordService;

	@Autowired
	private IWordContentService wordContentService;

	@Override
	public List<WordDto> getReciteWords(String userId, String type) throws Exception {
		if("plan".equalsIgnoreCase(type)){
			return this.getPlanedWord(userId);
		}else if("wrong".equalsIgnoreCase(type)){
			return this.getWrongWordList(userId);
		}else if("favorite".equalsIgnoreCase(type)){
			return this.getFavoriteWordList(userId);
		}

		return null;
	}

	/**
	 * 获取计划背诵的单词
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<WordDto> getPlanedWord(String userId) throws Exception {
		RecitePlanModel recitePlanModel = recitePlanService.getModel(userId);
		if(recitePlanModel == null){
			throw new AppException("1000", "没有可执行计划，请先制定学习计划");
		}

		Timestamp ts = DateUtil.getTimestamp();
		ReciteClockinModel clockinModel = null;
		List<ReciteClockinModel> clockinModelList = reciteClockinService.get(userId, recitePlanModel.getId());
		if(CollectionUtil.isEmpty(clockinModelList) ){
			clockinModel = new ReciteClockinModel();
		}else{
			clockinModel = clockinModelList.get(clockinModelList.size() - 1);
			if(! DateUtil.format(clockinModel.getClockinDate(),"yyyy-MM-dd").equalsIgnoreCase(DateUtil.format(ts, "yyyy-MM-dd"))){
				clockinModel = new ReciteClockinModel();
			}
		}

		if(StringUtil.isNullOrBlank(clockinModel.getId())){
			clockinModel.setBookId(recitePlanModel.getBookId());
			clockinModel.setPlanId(recitePlanModel.getId());
			clockinModel.setUserId(userId);
			clockinModel.setClockinDate(ts);
			clockinModel.setWordNum(recitePlanModel.getPlanWordNum());
			reciteClockinService.save(clockinModel);

			clockinModelList.add(clockinModel);
		}

		String firstWordId = null;
		int size = clockinModelList.size(), num = 0, wordNum = 0;
		for(int index = size - 1; index >= 0 && num++ < 3; index--){
			if(StringUtil.isNotNullAndBlank(clockinModelList.get(index).getFirstWordId())) {
				firstWordId = clockinModelList.get(index).getFirstWordId();
			}
			wordNum += clockinModelList.get(index).getWordNum();
		}

		if(StringUtil.isNullOrBlank(firstWordId)){
			firstWordId = "10000000";
		}
		List<WordModel> words = this.wordService.get(recitePlanModel.getBookId(), firstWordId, wordNum);
		List<WordDto> wordDtoList = get(words);

		clockinModel.setFirstWordId(wordDtoList.get(0).getWordId());
		clockinModel.setLastWordId(wordDtoList.get(words.size() - 1).getWordId());
		clockinModel.setWordNum(wordDtoList.size());
		reciteClockinService.save(clockinModel);

		return wordDtoList;
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<WordDto> getWrongWordList(String userId) throws Exception{
		List<UserWordModel> userWordModelList = userWordService.getWrongWords(userId);
		if(CollectionUtil.isEmpty(userWordModelList)){
			return null;
		}

		List<String> wordIds = new ArrayList<>();
		userWordModelList.stream().forEach(model -> wordIds.add(model.getWordId()));

		List<WordModel> wordModelList = wordService.get(wordIds);

		return get(wordModelList);
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<WordDto> getFavoriteWordList(String userId) throws Exception{
		List<UserWordModel> userWordModelList = userWordService.getFavoriteWords(userId);
		if(CollectionUtil.isEmpty(userWordModelList)){
			return null;
		}

		List<String> wordIds = new ArrayList<>();
		userWordModelList.stream().forEach(model -> wordIds.add(model.getWordId()));

		List<WordModel> wordModelList = wordService.get(wordIds);

		return get(wordModelList);
	}


	private List<WordDto> get(List<WordModel> wordModelList) throws Exception{
		List<WordDto> wordDtoList = new ArrayList<>();

		Map<String, WordModel> wordModelMap = new HashMap<>();
		List<String> wordIds = new ArrayList<>();
		wordModelList.forEach(model -> {
			wordModelMap.put(model.getId(), model);
			wordIds.add(model.getId());
		});

		List<WordContentModel> wordContentModelList = wordContentService.get(wordIds);
		if(CollectionUtil.isNotEmpty(wordContentModelList)){
			List<WordContentModel> contentModelList = new ArrayList<>();
			String wordId = null;
			for(WordContentModel wordContentModel : wordContentModelList){
				if(wordId != null && !wordContentModel.getWordId().equals(wordId)){
					wordDtoList.add(WordConvertor.INSTANCE.convert(wordModelMap.get(wordId), contentModelList));
					contentModelList.clear();
				}

				wordId = wordContentModel.getWordId();
				contentModelList.add(wordContentModel);
			}

			if(CollectionUtil.isNotEmpty(contentModelList)) {
				wordDtoList.add(WordConvertor.INSTANCE.convert(wordModelMap.get(wordId), contentModelList));
			}
		}

		return wordDtoList;
	}

	@Override
	public void saveWrongWord(String userId, String wordId) throws Exception {
		userWordService.saveWrongWord(userId, wordId);
	}

	@Override
	public void saveFavoriteWord(String userId, String wordId) throws Exception {
		userWordService.saveFavoriteWord(userId, wordId);
	}

	@Override
	public void saveFamiliarityWord(String userId, String wordId, String familiarity) throws Exception {
		userWordService.saveFamiliarityWord(userId, wordId, familiarity);
	}
}
