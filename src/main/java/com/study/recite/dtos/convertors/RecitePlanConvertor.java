package com.study.recite.dtos.convertors;


import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.models.BookModel;
import com.study.recite.models.RecitePlanModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by Tony on 2021/10/29.
 */
@Mapper
public interface RecitePlanConvertor {
	RecitePlanConvertor INSTANCE = Mappers.getMapper(RecitePlanConvertor.class);

	@Mappings({
		@Mapping(source="planModel.id", target="id"),
		@Mapping(source="bookModel.name", target="bookName")
	})
	RecitePlanDto convert(RecitePlanModel planModel, BookModel bookModel);
}
