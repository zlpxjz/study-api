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
	List<WordDto> get(String bookId, String firstWordId, int size) throws Exception;
}
