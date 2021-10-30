package com.study.notes.dtos.convertors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.study.notes.models.NoteModel;
import com.study.notes.dtos.NoteDto;

@Mapper
public interface NoteConvertor {
    NoteConvertor  INSTANCE = Mappers.getMapper(NoteConvertor.class);

    /**
     * 单个对象的转�?
     **/
    NoteDto convert(NoteModel noteModel);

    /**
    * 集合对象的转�?
    **/
    List<NoteDto> convert(List<NoteModel> noteModels);
}
