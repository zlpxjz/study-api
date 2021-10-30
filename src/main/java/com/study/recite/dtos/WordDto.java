package com.study.recite.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tony on 2021/10/29.
 */
@Data
public class WordDto {
	private String wordId;
	private String word;
	private Integer importance;

	@JsonIgnore
	List<WordContentDto> contents;

	public String getPron(){
		return contents.stream().filter(content->"音标".equalsIgnoreCase(content.getCategory()) && "美式".equalsIgnoreCase(content.getSubCategory())).findFirst().get().getContent1();
	}

	public List<WordContentDto> getPhrases(){
		return contents.stream().filter(content->"短语".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}

	public List<WordContentDto> getTranslations(){
		return contents.stream().filter(content->"释义".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}

	public List<WordContentDto> getRelatives(){
		return contents.stream().filter(content->"同根词".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}

	public List<WordContentDto> getExamples(){
		return contents.stream().filter(content->"例句".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}

	public List<WordContentDto> getDiscriminate(){
		return contents.stream().filter(content->"词语辨析".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}

	public List<WordContentDto> getSynonyms(){
		return contents.stream().filter(content->"同义词".equalsIgnoreCase(content.getCategory())).collect(Collectors.toList());
	}
}
