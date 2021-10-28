package com.study.recite.dtos.convertors;

import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.models.BookModel;
import com.study.recite.models.RecitePlanModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecitePlanConvertor {
    RecitePlanConvertor INSTANCE = Mappers.getMapper(RecitePlanConvertor.class);

    @Mappings({
        @Mapping(target = "id", source = "planModel.id"), @Mapping(target = "bookName", source = "bookModel.name"),
    })
    RecitePlanDto convert(RecitePlanModel planModel, BookModel bookModel);
}
