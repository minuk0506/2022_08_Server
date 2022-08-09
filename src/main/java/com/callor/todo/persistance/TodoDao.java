package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, String>{
	
	public void create_todo_table();
	public List<TodoVO> find_user(String username);
}
