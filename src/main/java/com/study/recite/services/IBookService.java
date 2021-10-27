package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.dtos.GetBookResponse;
import com.study.recite.dtos.GetBookRequest;
import com.study.recite.models.BookModel;

import java.util.List;

public interface IBookService extends IBaseService<Integer, BookModel>{
	/**
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<GetBookResponse> get(GetBookRequest request) throws Exception;
}
