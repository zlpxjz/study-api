package com.study.recite.services;

import com.fasterapp.base.arch.service.IBaseService;
import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.models.RecitePlanModel;

public interface IRecitePlanService extends IBaseService<String, RecitePlanModel> {
	/**
	 *
	 * @param planDto
	 * @throws Exception
	 */
	void save(String userId, RecitePlanDto planDto) throws Exception;

	/**
	 *
	 * @throws Exception
	 */
	RecitePlanDto get(String userId) throws Exception;

	/**
	 *
	 * @throws Exception
	 */
	RecitePlanModel getModel(String userId) throws Exception;
}
