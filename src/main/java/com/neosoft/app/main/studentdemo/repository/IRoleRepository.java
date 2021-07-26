package com.neosoft.app.main.studentdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.app.main.studentdemo.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{

}
