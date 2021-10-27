package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.recite.models.ReciteClockinModel;
import com.study.recite.services.IReciteClockinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/reciteClickin")
@Slf4j
@Api("ReciteClickin相关API")
public class ReciteClockinApi extends BaseApi {
    @Autowired
    private IReciteClockinService reciteClickinService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping
    public ApiResponse save(@RequestBody ReciteClockinModel model) throws Exception{
        reciteClickinService.save(model);
        return ApiResponse.success().setMessage("保存成功。");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}")
    public ApiResponse get(@PathVariable("id") Integer Id) throws Exception{
        ReciteClockinModel model = reciteClickinService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @DeleteMapping(path="/{id}")
    public ApiResponse delete(@PathVariable("id") Integer id) throws Exception{
        reciteClickinService.delete(id);
        return ApiResponse.success().setMessage("删除成功。");
    }
}
