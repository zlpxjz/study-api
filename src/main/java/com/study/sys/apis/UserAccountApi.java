package com.study.sys.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.sys.dtos.LoginDto;
import com.study.sys.dtos.UserDto;
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

    @RequestMapping(path="/login")
    public ApiResponse login(@RequestBody LoginDto loginDto) throws Exception{
        UserDto response = userAccountService.login(loginDto);
        return ApiResponse.success(response);
    }

    @RequestMapping(path="/logout")
    public ApiResponse logout() throws Exception{
        return ApiResponse.success();
    }

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/register")
    public ApiResponse register(@RequestBody UserDto userDto) throws Exception{
        userAccountService.register(userDto);
        return ApiResponse.success().setMessage("保存成功");
    }

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/update")
    public ApiResponse update(@RequestBody UserDto userDto) throws Exception{
        userAccountService.update(userDto);
        return ApiResponse.success().setMessage("保存成功");
    }

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/reset")
    public ApiResponse reset(@RequestBody UserDto userDto) throws Exception{
        userAccountService.reset(userDto);
        return ApiResponse.success().setMessage("保存成功");
    }


    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @DeleteMapping(path="/{id}")
    public ApiResponse delete(@PathVariable("id") String id) throws Exception{
        userAccountService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
