package com.github.elizabetht.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.elizabetht.model.Student;

@Controller
//@EnableWebMvc
public class MessageController {
	
	@RequestMapping(value="/method1",method=RequestMethod.GET,produces="application/json")	
	public @ResponseBody Student getResponse(){
		//@PathVariable("id") long id
		Student st = new Student();
		st.setActive(1);
		st.setFirstName("Vipin");
		st.setLastName("Shingade");
		st.setDateOfBirth(new Date());
		st.setEmailAddress("a@d.com");
		st.setPassword("45");
		st.setUserName("hhhh");
		return st;
	}

}
