package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.models.WordContentModel;

import java.util.List;

public interface IWordContentService extends IBaseService<String, WordContentModel> {
	/**
	 *
	 * @param wordIds
	 * @return
	 * @throws Exception
	 */
	List<WordContentModel> get(List<String> wordIds) throws Exception;
}
