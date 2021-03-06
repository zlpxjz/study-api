package com.study.recite.services.impl;

import com.study.common.BaseServiceImpl;
import com.study.recite.dtos.BookDto;
import com.study.recite.dtos.GetBookDto;
import com.study.recite.dtos.convertors.BookConvertor;
import com.study.recite.mappers.BookMapper;
import com.study.recite.models.BookModel;
import com.study.recite.services.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("BookService")
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl extends BaseServiceImpl<String, BookModel, BookMapper> implements IBookService {
	@Override
	public List<BookDto> get(GetBookDto request) throws Exception {
		List<BookModel> modelList = this.mapper.selectByGetBookRequest(request);
		return BookConvertor.INSTANCE.convert(modelList);
	}
}
