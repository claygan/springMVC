package com.quest.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quest")
public class Hello {
	
	@RequestMapping("/hello")
	public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
		
//		Object obj = (Object)request.getParameter("abc");
//		System.out.println(obj.equals("abc"));//造空指针异常
		
		model.addAttribute("message", "helloWorld");
		
		return "hello";
	}
}
