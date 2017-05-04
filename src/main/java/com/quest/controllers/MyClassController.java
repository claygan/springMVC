package com.quest.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.commons.ServiceFactory;
import com.quest.entity.WordItem;
import com.quest.pojos.Student;
import com.quest.service.HelloRemoteService;

@Controller
@RequestMapping("/myclass")
public class MyClassController {
	
	@Resource
	HelloRemoteService helloRemoteService;
	
	@RequestMapping("/student")
	public String queryStudent(HttpServletRequest request, HttpServletResponse response, Model model){
		
		Student student = ServiceFactory.getBean("student", Student.class);
		model.addAttribute("studentInfo", student.study());
		return "myclass/student";
	}
	
	@RequestMapping("/words")
	public String queryWords(HttpServletRequest request,Model model){
		helloRemoteService.saySomething("我是一只，小小的石头！");
		
		WordItem wordItem = helloRemoteService.listenWords("我是一只小蜜蜂", "嗡嗡嗡");
		System.out.println("words: "+wordItem.getWords());
		System.out.println("sound: "+wordItem.getSound());
		model.addAttribute("wordItem", wordItem);
		return "myclass/words";
	}
}
