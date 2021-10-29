package com.study.notes.apis;

import com.study.notes.models.NoteModel;
import com.study.notes.services.INoteService;
import com.fasterapp.base.arch.api.BaseApi;
import com.fasterapp.base.arch.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/note")
@Slf4j
@Api("Note相关API")
public class NoteApi extends BaseApi {
    @Autowired
    private INoteService noteService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping(path="/save")
    public ApiResponse save(@RequestBody NoteModel model) throws Exception{
        noteService.save(model);
        return ApiResponse.success().setMessage("保存成功�?");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}/get")
    public ApiResponse get(@PathVariable("id") Integer Id) throws Exception{
        NoteModel model = noteService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @GetMapping(path="/{id}/delete")
    public ApiResponse delete(@PathVariable("id") Integer id) throws Exception{
        noteService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
