package com.study.recite.apis;

import com.fasterapp.base.arch.ApiResponse;
import com.fasterapp.base.arch.api.BaseApi;
import com.study.recite.dtos.BookDto;
import com.study.recite.dtos.GetBookDto;
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

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @GetMapping(path="/{id}")
    public ApiResponse get(@PathVariable("id") String Id) throws Exception{
        BookModel model = bookService.getOne(Id);
        return ApiResponse.success(model);
    }

    @ApiOperation(value = "根据id获取信息", notes = "查询数据库中某个信息")
    @PostMapping()
    public ApiResponse get(@RequestBody GetBookDto request) throws Exception{
        List<BookDto> response = bookService.get(request);
        return ApiResponse.success(response);
    }
}
