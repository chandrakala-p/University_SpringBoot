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
import com.hcl.beans.Student;
import com.hcl.exception.IdNotFoundException;
import com.hcl.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)  {
		
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/selectSubject")
	public ResponseEntity<Student> selectSubject(@RequestBody Student student) throws IdNotFoundException  {
		
		return new ResponseEntity<Student>(studentService.selectSubject(student), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStudents")
	public ResponseEntity<List<Student>> getStudents() {

		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) throws IdNotFoundException {

		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleEmployeeIdException(HttpServletRequest request, Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);	
	}


}
