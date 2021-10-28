package com.study.recite.services.impl;

import com.fasterapp.base.arch.service.BaseServiceImpl;
import com.study.recite.services.IReciteClockinService;
import com.study.recite.mappers.ReciteClockinMapper;
import com.study.recite.models.ReciteClockinModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("ReciteClickinService")
@Transactional(rollbackFor = Exception.class)
public class ReciteClockinServiceImpl extends BaseServiceImpl<String, ReciteClockinModel, ReciteClockinMapper> implements IReciteClockinService {

}
