package com.study.recite.services.impl;

import com.study.recite.mappers.BookWordMapper;
import com.study.recite.models.BookWordModel;
import com.study.recite.services.IBookWordService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("BookWordService")
@Transactional(rollbackFor = Exception.class)
public class BookWordServiceImpl extends BaseServiceImpl<Integer, BookWordModel, BookWordMapper> implements IBookWordService {

}
