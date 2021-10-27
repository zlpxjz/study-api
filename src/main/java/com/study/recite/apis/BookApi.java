package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.recite.dtos.GetBookResponse;
import com.study.recite.dtos.GetBookRequest;
import com.study.recite.models.BookModel;
import com.study.recite.services.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/book")
@Slf4j
@Api("Book相关API")
public class BookApi extends BaseApi {
    @Autowired
    private IBookService bookService;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping
    public ApiResponse save(@RequestBody BookModel model) throws Exception{
        bookService.save(model);
        return ApiResponse.success().setMessage("保存成功�?");
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}")
    public ApiResponse get(@PathVariable("id") Integer Id) throws Exception{
        BookModel model = bookService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/get")
    public ApiResponse get(@RequestBody GetBookRequest request) throws Exception{
        List<GetBookResponse> response = bookService.get(request);
        return ApiResponse.success(response);
    }

    @ApiOperation(value = "删除指定数据", notes = "删除指定数据")
    @GetMapping(path="/{id}")
    public ApiResponse delete(@PathVariable("id") Integer id) throws Exception{
        bookService.delete(id);
        return ApiResponse.success().setMessage("删除成功�?");
    }
}
