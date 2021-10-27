package com.study.recite.dtos;

import com.study.recite.models.BookModel;

/**
 * Created by Tony on 2021/10/27.
 */
public class GetBookResponse {
	public static GetBookResponse build(BookModel model){
		GetBookResponse response = new GetBookResponse();

		return response;
	}
}