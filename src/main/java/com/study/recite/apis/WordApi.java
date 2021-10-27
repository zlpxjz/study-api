package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.recite.models.WordModel;
import com.study.recite.services.IWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/word")
@Slf4j
@Api("Word相关API")
public class WordApi extends BaseApi {
    @Autowired
    private IWordService wordService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping
    public ApiResponse save(@RequestBody WordModel model) throws Exception{
        wordService.save(model);
        return ApiResponse.success().setMessage("保存成功�?");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}")
    public ApiResponse get(@PathVariable("id") Integer Id) throws Exception{
        WordModel model = wordService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @DeleteMapping(path="/{id}")
    public ApiResponse delete(@PathVariable("id") Integer id) throws Exception{
        wordService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
