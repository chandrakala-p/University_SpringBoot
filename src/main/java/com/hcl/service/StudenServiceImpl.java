package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.beans.Student;
import com.hcl.dao.ICourseRepository;
import com.hcl.dao.IStudentRepository;
import com.hcl.exception.IdNotFoundException;

@Service
public class StudenServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	ICourseRepository courseRepo;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Integer studentId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return studentRepo.findById(studentId).orElseThrow(
				()-> new IdNotFoundException("student Id not found"));
	}

	@Override
	public Student selectSubject(Student student)throws IdNotFoundException {
		// TODO Auto-generated method stub
		Student s = studentRepo.findById(student.getStudentId()).orElseThrow(
				()-> new IdNotFoundException("student Id not found"));
		List<Course> courses = student.getCourses();
		List<Course> courseList = s.getCourses();
		courses.stream().forEach(c -> {
			try {
				Course course = courseRepo.findById(c.getCourseId()).orElseThrow(
						()-> new IdNotFoundException("Course Id not found"));
				courseList.add(c);
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		s.setCourses(courseList);
		return studentRepo.saveAndFlush(s) ;
	}


}
