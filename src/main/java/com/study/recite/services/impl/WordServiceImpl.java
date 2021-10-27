package com.study.recite.services.impl;

import com.study.recite.mappers.WordMapper;
import com.study.recite.models.WordModel;
import com.study.recite.services.IWordService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("WordService")
@Transactional(rollbackFor = Exception.class)
public class WordServiceImpl extends BaseServiceImpl<Integer, WordModel, WordMapper> implements IWordService {

}
