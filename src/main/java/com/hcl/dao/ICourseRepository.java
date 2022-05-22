package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
