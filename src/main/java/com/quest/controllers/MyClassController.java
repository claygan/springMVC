package com.quest.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.commons.ServiceFactory;
import com.quest.pojos.Student;

@Controller
@RequestMapping("/myclass")
public class MyClassController {
	
	@RequestMapping("/student")
	public String queryStudent(HttpServletRequest request, HttpServletResponse response, Model model){
		
		Student student = ServiceFactory.getBean("student", Student.class);
		model.addAttribute("studentInfo", student.study());
		return "student";
	}
}
