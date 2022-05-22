package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

}
