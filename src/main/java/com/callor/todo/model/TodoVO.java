package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TodoVO {
	
	private long seq;
	private String username;
	private String todo;
	private String date;
	private String time;
	private String compDate;
	private String compTime;
	private int comp;
		
}
