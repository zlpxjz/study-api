package com.study.notes.services.impl;

import com.study.notes.models.NoteModel;
import com.study.notes.mappers.NoteMapper;
import com.study.notes.services.INoteService;
import com.fasterapp.base.arch.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("NoteService")
@Transactional(rollbackFor = Exception.class)
public class NoteServiceImpl extends BaseServiceImpl<String, NoteModel, NoteMapper> implements INoteService {

}
