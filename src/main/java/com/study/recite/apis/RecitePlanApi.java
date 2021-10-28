package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.recite.dtos.RecitePlanDto;
import com.study.recite.services.IRecitePlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/recite/plan")
@Slf4j
@Api("RecitePlan相关API")
public class RecitePlanApi extends BaseApi {
    @Autowired
    private IRecitePlanService recitePlanService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/save")
    public ApiResponse save(@RequestBody RecitePlanDto planDto) throws Exception{
        recitePlanService.save(planDto);
        return ApiResponse.success().setMessage("保存成功");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping
    public ApiResponse get() throws Exception{
        RecitePlanDto planDto = recitePlanService.get();
        return ApiResponse.success(planDto);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @GetMapping(path="/{id}/delete")
    public ApiResponse delete(@PathVariable("id") String id) throws Exception{
        recitePlanService.delete(id);
        return ApiResponse.success().setMessage("删除成功");
    }
}
