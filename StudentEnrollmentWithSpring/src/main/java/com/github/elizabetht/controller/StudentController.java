package com.github.elizabetht.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.elizabetht.model.Student;
import com.github.elizabetht.model.StudentLogin;
import com.github.elizabetht.service.StudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();		
		model.addAttribute("student", student);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(studentService.findByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			student.setActive(1);
			studentService.save(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		StudentLogin studentLogin = new StudentLogin();		
		model.addAttribute("studentLogin", studentLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = studentService.findByLogin(studentLogin.getUserName(), studentLogin.getPassword());
			if (found) {				
				return "success";
			} else {				
				return "failure";
			}
		}
		
	}
	
	@RequestMapping(value="/studentDetail", method=RequestMethod.GET)
	public ModelAndView getStudentDetail(Model model) {
		Map<Long, String> lst = new LinkedHashMap<Long, String>();
		
		List<Student> lstStudent = studentService.getAllActiveStudent();
		
		for (Student student : lstStudent) {
			lst.put(student.getId(), student.toString());
		}
		
		Student student = new Student();		
		// This is mandatory as one of the attribute
		model.addAttribute("student", student);
		model.addAttribute("studentList", lst);		
		return new ModelAndView("StudentDetail");
	}
	
	@RequestMapping(value="/getStudentDetailByID")
	public ModelAndView getStudentDetailByID(@RequestParam("id")long id)
	{
		ModelAndView mav = new ModelAndView("StudentInfo");
		Student st = studentService.getStudentByID(id);
		mav.addObject("stud", st);
		return mav;
	}
	
}
