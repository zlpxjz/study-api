package com.study.recite.dtos.convertors;

import com.study.recite.dtos.WordDto;
import com.study.recite.models.WordContentModel;
import com.study.recite.models.WordModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Tony on 2021/10/29.
 */
@Mapper
public interface WordConvertor {
	WordConvertor INSTANCE = Mappers.getMapper(WordConvertor.class);

	List<WordDto> convert(List<WordModel> wordModel);

	@Mappings({
		@Mapping(source="wordModel.id", target="wordId")
	})
	WordDto convert(WordModel wordModel, List<WordContentModel> contents);
}
