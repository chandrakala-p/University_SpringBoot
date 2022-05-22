package com.hcl.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "student_courses",
		joinColumns = { @JoinColumn(name = "student_id") },
		inverseJoinColumns = { @JoinColumn (name = "course_id")}
	)
	
	private List<Course> courses;
}
