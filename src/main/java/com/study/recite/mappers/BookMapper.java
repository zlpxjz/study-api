package com.study.recite.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.dtos.GetBookRequest;
import com.study.recite.models.BookModel;

import java.util.List;

public interface BookMapper extends BaseMapper<Integer, BookModel> {
	List<BookModel> selectByGetBookRequest(GetBookRequest request);
}

