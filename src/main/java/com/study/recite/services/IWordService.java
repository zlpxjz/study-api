package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.dtos.WordDto;
import com.study.recite.models.WordModel;

import java.util.List;

public interface IWordService extends IBaseService<String, WordModel> {
	/**
	 *
	 * @param bookId
	 * @param firstWordId
	 * @param size
	 * @return
	 * @throws Exception
	 */
	List<WordModel> get(String bookId, String firstWordId, int size) throws Exception;

	/**
	 *
	 * @param wordIds
	 * @return
	 * @throws Exception
	 */
	List<WordModel> get(List<String> wordIds) throws Exception;
}
