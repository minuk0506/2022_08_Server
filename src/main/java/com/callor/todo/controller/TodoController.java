package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.service.impl.TodoServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	private TodoServiceImplV1 todoService;
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String todo(Principal principal, Model model) {
		log.debug("투두 리스트 {}",principal.getName());
		List<TodoVO> todoList = todoService.find_user(principal.getName());
		log.debug("리스트 결과 {}", todoList);
		model.addAttribute("todoList",todoList);
		model.addAttribute("LAYOUT","TODO");
		return null;
	}
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public String todo(@AuthenticationPrincipal UserVO userVO, @ModelAttribute("TODO") TodoVO todoVO) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:SS");
		
		TodoVO todoDate = TodoVO.builder()
						.date(day.format(date))
						.time(time.format(date))
						.build();
		log.debug("투두 VO 저장하기 {}",todoVO);
		todoService.insert(todoVO);
		return "redirect:/";
	}
}
