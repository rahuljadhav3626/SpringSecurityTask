package com.neosoft.app.main.studentdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.app.main.studentdemo.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	

	Student findByUsername(String username);

	//Student findByUsername(String username);
}
