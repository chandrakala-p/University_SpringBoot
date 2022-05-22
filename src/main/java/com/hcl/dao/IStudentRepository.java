package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student , Integer>{

}
