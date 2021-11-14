package com.study.recite.dtos.convertors;


import com.study.recite.dtos.ReciteClockinDto;
import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.dtos.WordDto;
import com.study.recite.models.BookModel;
import com.study.recite.models.ReciteClockinModel;
import com.study.recite.models.RecitePlanModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Tony on 2021/10/29.
 */
@Mapper
public interface ReciteClockinConvertor {
	ReciteClockinConvertor INSTANCE = Mappers.getMapper(ReciteClockinConvertor.class);

	@Mappings({
		@Mapping(source="clockinModel.id", target="clockinId"),
        @Mapping(source="wordDtos", target="words")
	})
	ReciteClockinDto convert(ReciteClockinModel clockinModel, List<WordDto> wordDtos);
}
