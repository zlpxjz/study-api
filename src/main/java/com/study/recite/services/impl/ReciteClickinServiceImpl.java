package com.study.recite.services.impl;

import com.study.recite.models.ReciteClickinModel;
import com.study.recite.mappers.ReciteClickinMapper;
import com.study.recite.services.IReciteClickinService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("ReciteClickinService")
@Transactional(rollbackFor = Exception.class)
public class ReciteClickinServiceImpl extends BaseServiceImpl<String, ReciteClickinModel, ReciteClickinMapper> implements IReciteClickinService {

}
