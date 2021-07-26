package com.neosoft.app.main.studentdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.app.main.studentdemo.entity.Student;
import com.neosoft.app.main.studentdemo.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	IStudentService studentService;

	
	@PreAuthorize("hasAnyRole('STUDENT')")
	@RequestMapping(value = "/studentAcess", method = RequestMethod.POST, produces = { "application/json",
			"aplication/json" })
	public String addStudentByStudent(@RequestBody Student student) {
		studentService.addStudentByStudent(student);
		return "student added successfully... by student itself";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @RequestMapping(value="/studentAcess" ,method = RequestMethod.GET) public
	 * String studentAcess() { return "sucess by student"; }
	 */
	/*
	 * @RequestMapping(value = "/studentAcess/save", method = RequestMethod.POST,
	 * consumes = { "application/json", "application/json" }) public Student
	 * insertStudent(@RequestBody Student student) { return
	 * studentService.insertStudent(student); }
	 */
}
