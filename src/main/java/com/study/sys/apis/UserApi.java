package com.study.sys.apis;

import com.study.sys.models.UserModel;
import com.study.sys.services.IUserService;
import com.fasterapp.base.arch.api.BaseApi;
import com.fasterapp.base.arch.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/userProfile")
@Slf4j
@Api("UserProfile相关API")
public class UserApi extends BaseApi {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/save")
    public ApiResponse save(@RequestBody UserModel model) throws Exception{
        userService.save(model);
        return ApiResponse.success().setMessage("保存成功�?");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}/get")
    public ApiResponse get(@PathVariable("id") String Id) throws Exception{
        UserModel model = userService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @GetMapping(path="/{id}/delete")
    public ApiResponse delete(@PathVariable("id") String id) throws Exception{
        userService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
