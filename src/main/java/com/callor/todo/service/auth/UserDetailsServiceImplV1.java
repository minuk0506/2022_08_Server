package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

@Service("userDetailsService")
public class UserDetailsServiceImplV1 implements UserDetailsService{

	private final UserDao userDao;
	
	public UserDetailsServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVO userVO = userDao.findById(username);

		if(userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입을 먼저 하세요");
		}

		List<AuthorityVO> authos = userDao.select_auths(username);
		
		if(authos.size() < 1) {
			throw new UsernameNotFoundException(
					String.format("[ %s ] 아무런 권한이 없습니다", username));
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		for(AuthorityVO auth : authos) {
			grantList.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		userVO.setAuthorities(grantList);
		
		return userVO;
	}

}