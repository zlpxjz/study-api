package com.study.recite.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.dtos.GetBookDto;
import com.study.recite.models.BookModel;

import java.util.List;

public interface BookMapper extends BaseMapper<String, BookModel> {
	List<BookModel> selectByGetBookRequest(GetBookDto request);
}

