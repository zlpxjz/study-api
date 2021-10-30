package com.study.recite.services.impl;

import com.study.common.BaseServiceImpl;
import com.study.recite.models.UserWordModel;
import com.study.recite.mappers.UserWordMapper;
import com.study.recite.services.IUserWordService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("UserWordService")
@Transactional(rollbackFor = Exception.class)
public class UserWordServiceImpl extends BaseServiceImpl<String, UserWordModel, UserWordMapper> implements IUserWordService {

    @Override
    public void saveWrongWord(String userId, String wordId) throws Exception {
        UserWordModel userWordModel = this.mapper.selectByUserAndWord(userId, wordId);
        if(userWordModel == null){
            userWordModel = new UserWordModel();
            userWordModel.setUserId(userId);
            userWordModel.setWordId(wordId);
        }

        userWordModel.setWrong("Y");

        this.save(userWordModel);
    }

    @Override
    public void saveFavoriteWord(String userId, String wordId) throws Exception {
        UserWordModel userWordModel = this.mapper.selectByUserAndWord(userId, wordId);
        if(userWordModel == null){
            userWordModel = new UserWordModel();
            userWordModel.setUserId(userId);
            userWordModel.setWordId(wordId);
        }

        userWordModel.setFavorited("Y");

        this.save(userWordModel);
    }

    @Override
    public void saveFamiliarityWord(String userId, String wordId, String familiarity) throws Exception {
        UserWordModel userWordModel = this.mapper.selectByUserAndWord(userId, wordId);
        if(userWordModel == null){
            userWordModel = new UserWordModel();
            userWordModel.setUserId(userId);
            userWordModel.setWordId(wordId);
        }

        userWordModel.setFamiliarity(familiarity);

        this.save(userWordModel);
    }

    @Override
    public List<UserWordModel> getWrongWords(String userId) throws Exception {
        return mapper.selectWrongWordByUser(userId);
    }

    @Override
    public List<UserWordModel> getFavoriteWords(String userId) throws Exception {
        return mapper.selectFavoiteWordByUser(userId);
    }
}
