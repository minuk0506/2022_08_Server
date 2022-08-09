package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoServiceImplV1 implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public void create_todo_table() {
		todoDao.create_todo_table();
		
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoVO findById(String id) {
		
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TodoVO> find_user(String username) {
		log.debug("서비스 유저네임{}",username);
		return todoDao.find_user(username);
	}

}
