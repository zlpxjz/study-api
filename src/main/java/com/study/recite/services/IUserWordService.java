package com.study.recite.services;

import com.study.recite.models.UserWordModel;
import com.fasterapp.base.arch.service.IBaseService;

import java.util.List;

public interface IUserWordService extends IBaseService<String, UserWordModel> {
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
     * @return
     * @throws Exception
     */
    List<UserWordModel> getWrongWords(String userId) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<UserWordModel> getFavoriteWords(String userId) throws Exception;

    /**
     *
     * @param userId
     * @param wordId
     * @param familiarity
     * @throws Exception
     */
    void saveFamiliarityWord(String userId, String wordId, String familiarity) throws Exception;
}
