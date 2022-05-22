package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.beans.Teacher;
import com.hcl.exception.IdNotFoundException;


public interface ITeacherService {

	public Teacher addTeacher(Teacher teacher);
	
	public List<Teacher> getAllTeachers();
	
	public Teacher getTeacherById(Integer teacherId) throws IdNotFoundException;
	
	public boolean assignCourse(Teacher teacher, List<Course> course);
	

}
