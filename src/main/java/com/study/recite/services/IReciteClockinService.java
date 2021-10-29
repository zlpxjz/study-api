package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.models.ReciteClockinModel;

import java.util.List;

public interface IReciteClockinService extends IBaseService<String, ReciteClockinModel> {
	/**
	 *
	 * @param userId
	 * @param planId
	 * @return
	 * @throws Exception
	 */
	List<ReciteClockinModel> get(String userId, String planId) throws Exception;
}
