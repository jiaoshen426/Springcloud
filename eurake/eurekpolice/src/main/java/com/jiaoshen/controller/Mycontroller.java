package com.jiaoshen.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiaoshen.bean.Person;

@RestController
public class Mycontroller {
  
	@RequestMapping(value="/person/{personId}",method=RequestMethod.GET)
	public Person findPerson(@PathVariable("personId")String personId,HttpServletRequest request){
		Person p1=new Person();
		p1.setId(personId);
		p1.setAge(20);
		p1.setName(request.getRequestURL().toString());
		return p1;
	}
}
