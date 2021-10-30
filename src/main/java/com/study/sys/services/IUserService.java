package com.study.sys.services;

import com.study.sys.models.UserModel;
import com.fasterapp.base.arch.service.IBaseService;

public interface IUserService extends IBaseService<String, UserModel> {
    /**
     *
     * @param accountId
     * @return
     * @throws Exception
     */
    UserModel getByAccount(String accountId) throws Exception;
}
