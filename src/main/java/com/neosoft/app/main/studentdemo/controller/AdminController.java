package com.neosoft.app.main.studentdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.app.main.studentdemo.entity.Student;
import com.neosoft.app.main.studentdemo.service.IStudentService;

//@SuppressWarnings("deprecation")
@RestController
//@EnableOAuth2Sso
public class AdminController {

	@Autowired
	IStudentService studentService;
	@RequestMapping(value = "/adminAcess/add", method = RequestMethod.POST, produces = { "application/json",
			"aplication/json" })
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "student added successfully...";

	}

	@RequestMapping(value = "/adminAcess/student", method = RequestMethod.GET, produces = { "application/json",
			"aplication/json" })
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@RequestMapping(value = "/adminAcess/{id}", method = RequestMethod.GET, produces = { "application/json",
			"aplication/json" })
	public Student findById(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * @GetMapping("/") public String validatee(Principal principle) { return
	 * "Hello Demo"; }
	 */

	/*
	 * @RequestMapping(value="/adminAcess",method = RequestMethod.GET) public String
	 * adminAcess() { return "sucess by admin"; }
	 */

}
