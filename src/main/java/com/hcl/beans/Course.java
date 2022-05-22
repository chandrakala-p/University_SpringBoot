package com.hcl.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CourseId;
	private String name;
	
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "teacher_id")
    private Teacher teacher;
	
	@ManyToMany(mappedBy = "courses", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Student> student;
}
