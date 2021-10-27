package com.study.recite.services.impl;

import com.fasterapp.base.arch.service.BaseServiceImpl;
import com.fasterapp.base.utils.CollectionUtil;
import com.study.recite.dtos.GetBookResponse;
import com.study.recite.dtos.GetBookRequest;
import com.study.recite.mappers.BookMapper;
import com.study.recite.models.BookModel;
import com.study.recite.services.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("BookService")
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl extends BaseServiceImpl<Integer, BookModel, BookMapper> implements IBookService {
	@Override
	public List<GetBookResponse> get(GetBookRequest request) throws Exception {
		List<GetBookResponse> response = new ArrayList<>();

		List<BookModel> modelList = this.mapper.selectByGetBookRequest(request);
		if(CollectionUtil.isNotEmpty(modelList)){
			for(BookModel bookModel : modelList) {
				response.add(GetBookResponse.build(bookModel));
			}
		}

		return response;
	}
}
