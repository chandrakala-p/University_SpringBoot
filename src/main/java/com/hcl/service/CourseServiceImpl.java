package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.beans.Teacher;
import com.hcl.dao.ICourseRepository;
import com.hcl.dao.ITeacherRepository;
import com.hcl.exception.IdNotFoundException;

@Service
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	ICourseRepository repo;
	
	@Autowired
	private ITeacherRepository teacherRepo;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return repo.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Course getCourseById(int courseId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(courseId).orElseThrow(()-> new IdNotFoundException("Course Id Not Exist.!"));
	}

	@Override
	public Course assignTeacher(Course course) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Course c = repo.findById(course.getCourseId()).orElseThrow(()-> new IdNotFoundException("Course Id Not Exist.!"));
		Teacher t = teacherRepo.findById(course.getTeacher().getTeacherId()).orElseThrow(()-> new IdNotFoundException("Teacher Id Not Exist.!"));
		c.setTeacher(t);	
		return repo.saveAndFlush(c);
	}

}
