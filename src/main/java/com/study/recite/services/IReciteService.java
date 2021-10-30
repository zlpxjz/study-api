package com.study.recite.services;

import com.study.recite.dtos.WordDto;

import java.util.List;

/**
 * Created by Tony on 2021/10/29.
 */
public interface IReciteService {
	/**
	 *
	 * @param userId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<WordDto> getReciteWords(String userId, String type) throws Exception;
}
