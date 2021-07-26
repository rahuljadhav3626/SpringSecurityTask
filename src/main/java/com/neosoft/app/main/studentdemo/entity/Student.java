package com.neosoft.app.main.studentdemo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String username;
	private String password;
	@NotEmpty(message = "Should Not Empty")
	@Size(min = 2, max = 12)
	private String firstname;
	@NotEmpty(message = "Should Not Empty")
	@Size(min = 2, max = 12)
	private String lastname;
	@NotEmpty(message = "Should Not Empty")
	@Size(max = 10)
	private String mobileNumber;
	//@Email
	@NotEmpty(message = "Should Not Empty")
	@Size(min = 2, max = 20)
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Project> project;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_role", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

}
