package com.study.recite.dtos.convertors;

import com.study.recite.dtos.BookDto;
import com.study.recite.models.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Tony on 2021/10/29.
 */
@Mapper
public interface BookConvertor {
	BookConvertor INSTANCE = Mappers.getMapper(BookConvertor.class);

	List<BookDto> convert(List<BookModel> bookModels);
}
