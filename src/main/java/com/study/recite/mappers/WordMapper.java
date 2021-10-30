package com.study.recite.mappers;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.study.recite.models.WordModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordMapper extends BaseMapper<String, WordModel> {
	List<WordModel> selectByBookAndFirstWordIdAndSize(@Param("bookId") String bookId, @Param("firstWordId") String firstWordId, @Param("size") int size);

	List<WordModel> selectByIds(@Param("wordIds") List<String> wordIds);
}

