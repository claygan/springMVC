package com.quest.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.commons.ServiceFactory;
import com.quest.pojos.Student;

/** 
 * @ClassName: Hello
 * @Description: TODO(用一句话描述这个类)
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2017年4月26日 下午5:28:25
 */  
@Controller
@RequestMapping("/quest")
public class Hello {
	private static Logger logger = LoggerFactory.getLogger(Hello.class);
	
	@RequestMapping("/hello")
	public String toHello(HttpServletRequest request, HttpServletResponse response, Model model){
		
		Object obj = (Object)request.getParameter("abc");
		System.out.println(obj.equals("abc"));//造空指针异常
		
		model.addAttribute("message", "helloWorld");
		logger.debug("------------->debug");
		logger.info("------------->info");
		logger.warn("------------->warn");
		logger.trace("------------->trace");
		logger.error("------------->errors");
		return "hello";
	}
	@SuppressWarnings("resource")
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		Student student = ac.getBean("student", Student.class);
		System.out.println(student);
		model.addAttribute("message", student.toString());
		return "hello";
	}
	
}
