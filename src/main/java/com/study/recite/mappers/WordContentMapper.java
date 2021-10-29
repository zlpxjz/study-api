package com.study.recite.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.models.WordContentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordContentMapper extends BaseMapper<String, WordContentModel> {
	List<WordContentModel> selectByWord(@Param("wordId") String wordId);
}

