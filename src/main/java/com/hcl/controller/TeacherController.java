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

import com.hcl.beans.ResponseMessage;
import com.hcl.beans.Teacher;
import com.hcl.exception.IdNotFoundException;
import com.hcl.service.ITeacherService;

@RestController
public class TeacherController {

	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addTeacher")
	public ResponseEntity<Teacher> addAddress(@RequestBody Teacher teacher)  {
		
		return new ResponseEntity<Teacher>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTeachers")
	public ResponseEntity<List<Teacher>> getTeachers() {

		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTeacher/{teacherId}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("teacherId") Integer teacherId) throws IdNotFoundException {

		return new ResponseEntity<Teacher>(teacherService.getTeacherById(teacherId), HttpStatus.OK);
	}
	

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleEmployeeIdException(HttpServletRequest request, Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);	
	}


}
