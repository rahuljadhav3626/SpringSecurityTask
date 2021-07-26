package com.neosoft.app.main.studentdemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.app.main.studentdemo.entity.Student;
import com.neosoft.app.main.studentdemo.repository.IStudentRepository;
import com.neosoft.app.main.studentdemo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	IStudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public Student insertStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		
		Optional<Student> student = studentRepository.findById(id);
		Student s =student.get();
		return s;
	}

	@Override
	public String addStudent(Student student) {
		String pwd = student.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		student.setPassword(encryptPwd);
		studentRepository.save(student);
		return "student add sucessfully";
	}

	@Override
	public String addStudentByStudent(Student student) {
		String pwd = student.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		student.setPassword(encryptPwd);
		studentRepository.save(student);
		return "student add sucessfully by Student";
		
	}

}
