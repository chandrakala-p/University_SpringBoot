package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.exception.IdNotFoundException;


public interface ICourseService {

	public Course addCourse(Course course);
	
	public List<Course> getAllCourses();
	
	public Course getCourseById(int courseId) throws IdNotFoundException;
	
	public Course assignTeacher(Course course)throws IdNotFoundException;
}
