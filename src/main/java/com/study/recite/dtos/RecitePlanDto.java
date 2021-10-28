package com.study.recite.dtos;

import com.study.recite.models.RecitePlanModel;
import lombok.Data;

/**
 * Created by Tony on 2021/10/28.
 */
@Data
public class RecitePlanDto {
	private String id;
	private String bookId;
	private String  bookName;
	private Integer planWordNum;
	private Integer planPhraseNum;
	private Integer totalWordNum;
	private Integer totalPhraseNum;
	private Integer recitedWordNum;
	private Integer recitedPhraseNum;
	private Integer repeatTimes;
	private Integer clockinTimes;
	private String reciteStatus;

	public static RecitePlanDto build(RecitePlanModel planModel){
		RecitePlanDto planDto = new RecitePlanDto();

		return planDto;
	}
}
