package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.beans.Student;
import com.hcl.exception.IdNotFoundException;


public interface IStudentService {

	public Student addStudent(Student teacher);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer studentId) throws IdNotFoundException;
	
	public Student selectSubject(Student student)throws IdNotFoundException;


}
