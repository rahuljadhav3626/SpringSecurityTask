package com.neosoft.app.main.studentdemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.app.main.studentdemo.entity.Student;
import com.neosoft.app.main.studentdemo.repository.IStudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student =studentRepository.findByUsername(username);
		CustomUserDetails userDetails = null ;
		if(student != null) {
			userDetails = new CustomUserDetails();
			userDetails.setStudent(student);
		}
		else {
			throw new UsernameNotFoundException("student not exist with name :: "+ username);
		}
		return userDetails;
	}
 
	
}
