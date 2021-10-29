package com.study.notes.models;

import com.fasterapp.base.arch.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tony on 2021/10/29.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Note")
@Table(name= "t_note_info")
public class NoteModel  extends BaseModel<String> {
	@Column(name="real_name", columnDefinition = "varchar(32) not null comment '主题'")
	private String subject;
}
