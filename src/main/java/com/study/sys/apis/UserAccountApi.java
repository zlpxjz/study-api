package com.study.sys.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.sys.models.UserAccountModel;
import com.study.sys.services.IUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
@Slf4j
@Api("User相关API")
public class UserAccountApi extends BaseApi {
    @Autowired
    private IUserAccountService userAccountService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping
    public ApiResponse save(@RequestBody UserAccountModel model) throws Exception{
        userAccountService.save(model);
        return ApiResponse.success().setMessage("保存成功�?");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}")
    public ApiResponse get(@PathVariable("id") String Id) throws Exception{
        UserAccountModel model = userAccountService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @DeleteMapping(path="/{id}")
    public ApiResponse delete(@PathVariable("id") String id) throws Exception{
        userAccountService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
