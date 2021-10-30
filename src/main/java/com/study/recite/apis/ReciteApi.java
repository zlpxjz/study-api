package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.common.SessionContext;
import com.study.recite.services.IReciteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/recite/")
@Slf4j
@Api("Recite相关API")
public class ReciteApi extends BaseApi {
    @Autowired
    private IReciteService reciteService;

    @ApiOperation(value = "根据id获取信息", notes = "获取背诵单词")
    @GetMapping(path="/words/{type}")
    public ApiResponse get(@PathVariable("type") String type) throws Exception{
        String userId = SessionContext.getUserId();
        return ApiResponse.success(reciteService.getReciteWords(userId, type));
    }
}
