package com.callor.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String error, String exception, Model model) {
		model.addAttribute("error",error);
		model.addAttribute("exception",exception);
		model.addAttribute("LAYOUT","LOGIN");
		return null;
	}
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return null;
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);
		return null;
	}	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage() {
		return null;
	}
}
