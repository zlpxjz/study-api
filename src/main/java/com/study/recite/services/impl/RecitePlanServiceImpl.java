package com.study.recite.services.impl;

import com.study.recite.models.RecitePlanModel;
import com.study.recite.mappers.RecitePlanMapper;
import com.study.recite.services.IRecitePlanService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("RecitePlanService")
@Transactional(rollbackFor = Exception.class)
public class RecitePlanServiceImpl extends BaseServiceImpl<Integer, RecitePlanModel, RecitePlanMapper> implements IRecitePlanService {

}
