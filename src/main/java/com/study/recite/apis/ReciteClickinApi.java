package com.study.recite.apis;

import com.study.recite.models.ReciteClickinModel;
import com.study.recite.services.IReciteClickinService;
import com.fasterapp.base.arch.api.BaseApi;
import com.fasterapp.base.arch.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/reciteClickin")
@Slf4j
@Api("ReciteClickin相关API")
public class ReciteClickinApi extends BaseApi {
    @Autowired
    private IReciteClickinService reciteClickinService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/save")
    public ApiResponse save(@RequestBody ReciteClickinModel model) throws Exception{
        reciteClickinService.save(model);
        return ApiResponse.success().setMessage("保存成功。");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}/get")
    public ApiResponse get(@PathVariable("id") Integer Id) throws Exception{
        ReciteClickinModel model = reciteClickinService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @GetMapping(path="/{id}/delete")
    public ApiResponse delete(@PathVariable("id") Integer id) throws Exception{
        reciteClickinService.delete(id);
        return ApiResponse.success().setMessage("删除成功。");
    }
}
