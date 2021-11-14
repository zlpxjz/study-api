package com.study.recite.services;

import com.study.recite.dtos.ReciteClockinDto;
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
	ReciteClockinDto getReciteWords(String userId, String type) throws Exception;

	/**
	 *
	 * @param userId
	 * @param wordId
	 * @throws Exception
	 */
	void saveWrongWord(String userId, String wordId) throws Exception;

	/**
	 *
	 * @param userId
	 * @param wordId
	 * @throws Exception
	 */
	void saveFavoriteWord(String userId, String wordId) throws Exception;

	/**
	 *
	 * @param userId
	 * @param wordId
	 * @throws Exception
	 */
	void saveFamiliarityWord(String userId, String wordId, String familiarity) throws Exception;



}
