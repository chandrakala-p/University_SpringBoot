package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Course;
import com.hcl.beans.Teacher;
import com.hcl.dao.ITeacherRepository;
import com.hcl.exception.IdNotFoundException;

@Service
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private ITeacherRepository teacherRepo;
	@Override
	public Teacher addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub

		return teacherRepo.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return teacherRepo.findAll();
	}

	@Override
	public Teacher getTeacherById(Integer teacherId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return teacherRepo.findById(teacherId).orElseThrow(
				()-> new IdNotFoundException("teacher Id not found"));
	}

	@Override
	public boolean assignCourse(Teacher teacher, List<Course> course) {
		// TODO Auto-generated method stub
		return false;
	}


}
