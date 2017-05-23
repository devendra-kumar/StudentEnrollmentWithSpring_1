package com.github.elizabetht.service;

import java.util.List;

import com.github.elizabetht.model.Student;

public interface StudentService extends BaseService<Student> {
	
	public List<Student> getAllActiveStudent();
	public Student getStudentByID(long id);
	boolean findByUserName(String userName);
	boolean findByLogin(String userName, String password);
}
