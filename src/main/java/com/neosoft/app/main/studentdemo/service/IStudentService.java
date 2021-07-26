package com.neosoft.app.main.studentdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.neosoft.app.main.studentdemo.entity.Student;


public interface IStudentService {
	

	public Student insertStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student findById(int id);
	
	public String addStudent(@RequestBody Student student);
	
	public String addStudentByStudent(@RequestBody Student student);

}
