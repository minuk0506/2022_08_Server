package com.callor.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Bean("passwordEncoder")
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void create_user_table() {
		userDao.create_user_table();		
	}

	@Override
	public void create_auth_table() {
		userDao.create_auth_table();		
	}

	@Override
	public List<AuthorityVO> select_auths(String username) {
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		
		List<UserVO> users = userDao.selectAll();
		List<AuthorityVO> auths = new ArrayList<>();

		if(users == null || users.size() < 1) {
			vo.setEnabled(true);
			auths.add(AuthorityVO.builder().username(vo.getUsername())
				.authority("ROLE_ADMIN").build());
			auths.add(AuthorityVO.builder().username(vo.getUsername())
					.authority("ROLE_USER").build());
		} else {
			auths.add(AuthorityVO.builder().username(vo.getUsername())
					.authority("ROLE_USER").build());
		
		}
		
		String encPassword = getPassword().encode(vo.getPassword());
		vo.setPassword(encPassword);
		userDao.role_insert(auths);
		return userDao.insert(vo);
		
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int role_insert(List<AuthorityVO> auths) {
		// TODO Auto-generated method stub
		return 0;
	}


}
