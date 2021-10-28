package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.dtos.BookDto;
import com.study.recite.dtos.GetBookDto;
import com.study.recite.models.BookModel;

import java.util.List;

public interface IBookService extends IBaseService<String, BookModel>{
	/**
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<BookDto> get(GetBookDto request) throws Exception;
}
