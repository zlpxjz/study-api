package com.study.common;

import com.fasterapp.base.arch.mapper.BaseMapper;
import com.fasterapp.base.arch.model.BaseModel;
import com.fasterapp.base.utils.DateUtil;
import com.fasterapp.base.utils.StringUtil;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Tony on 2021/10/28.
 */
public class BaseServiceImpl<K extends Serializable, E extends BaseModel, M extends BaseMapper<K, E>> extends com.fasterapp.base.arch.service.BaseServiceImpl<K, E, M> {
	@Override
	public void save(E model) throws Exception {
		Timestamp ts = DateUtil.getTimestamp();
		String userId = SessionContext.getUserId();
		if(model.isInsert()){
			model.setId(StringUtil.getUUID());
			model.setCreatedBy(SessionContext.getUserId());
			model.setCreatedDate(ts);
		}

		model.setUpdatedBy(userId);
		model.setUpdatedDate(ts);
		super.save(model);
	}
}
