package com.callor.todo.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVO implements UserDetails { // extends User {

	private static final long serialVersionUID = 1L;

	private long id;
	private String username;
	private String password;
	private boolean Enabled;
	private boolean AccountNonExpired;
	private boolean AccountNonLocked;
	private boolean CredentialsNonExpired;
	private Collection<? extends GrantedAuthority> authorities; // getAuthorities

	private String email;
	private String tel;
	private String address;
	
	private String realname;
	private String nickname;


}
