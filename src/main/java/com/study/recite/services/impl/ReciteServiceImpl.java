package com.study.recite.services.impl;

import com.fasterapp.base.AppException;
import com.fasterapp.base.utils.CollectionUtil;
import com.fasterapp.base.utils.DateUtil;
import com.fasterapp.base.utils.StringUtil;
import com.study.recite.dtos.WordDto;
import com.study.recite.models.ReciteClockinModel;
import com.study.recite.models.RecitePlanModel;
import com.study.recite.services.IReciteClockinService;
import com.study.recite.services.IRecitePlanService;
import com.study.recite.services.IReciteService;
import com.study.recite.services.IWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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

	@Override
	public List<WordDto> getReciteWords(String userId, int type) throws Exception {
		if(type == 1){
			return this.getReciteWordsAsPlan(userId);
		}

		return null;
	}

	/**
	 * 获取计划背诵的单词
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<WordDto> getReciteWordsAsPlan(String userId) throws Exception {
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
			if(! DateUtil.format(clockinModel.getClockinDate(),"yyyy-MM-dd").equalsIgnoreCase(DateUtil.format(ts))){
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
			firstWordId = clockinModelList.get(index).getFirstWordId();
			wordNum += clockinModelList.get(index).getWordNum();
		}

		List<WordDto> words = this.wordService.get(recitePlanModel.getBookId(), firstWordId, wordNum);
		clockinModel.setFirstPhraseId(words.get(0).getWordId());
		clockinModel.setLastWordId(words.get(words.size() - 1).getWordId());
		clockinModel.setWordNum(words.size());
		reciteClockinService.save(clockinModel);

		return words;
	}
}
