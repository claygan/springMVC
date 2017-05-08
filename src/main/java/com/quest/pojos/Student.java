package com.quest.pojos;

import org.springframework.util.StringUtils;

public class Student extends MyClass{
	private String name;
	public Student(int classNum, int age, String name){
		super.classNum = classNum;
		super.age = age;
		this.name = name;
	}
	public Student(){
		super.classNum = 0;
		super.age = 0;
		name = "";
	}
	
	public String study(){
		if(StringUtils.isEmpty(name)){
			System.out.println("This student is not regist!");
			return "This student is not regist!";
		}else{
			System.out.println("My name is "+name+",I'm in "+classNum+" class,and my age is "+ age);
			return "My name is "+name+",I'm in "+classNum+" class,and my age is "+ age;
		}
	}
}
