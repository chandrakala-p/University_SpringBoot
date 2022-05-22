package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Course;
import com.hcl.beans.ResponseMessage;
import com.hcl.exception.IdNotFoundException;
import com.hcl.service.ICourseService;


@RestController
public class CourseController {

	@Autowired
	private ICourseService courseService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course)  {
		
		return new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/assignTeacher")
	public ResponseEntity<Course> assignTeacher(@RequestBody Course course) throws IdNotFoundException  {
		
		return new ResponseEntity<Course>(courseService.assignTeacher(course), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCourses")
	public ResponseEntity<List<Course>> getCourses() {

		return new ResponseEntity<List<Course>>(courseService.getAllCourses(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCourse/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseId") Integer courseId) throws IdNotFoundException {

		return new ResponseEntity<Course>(courseService.getCourseById(courseId), HttpStatus.OK);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleEmployeeIdException(HttpServletRequest request, Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);	
	}

}
