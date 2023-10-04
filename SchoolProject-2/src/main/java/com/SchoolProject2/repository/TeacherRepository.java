package com.SchoolProject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolProject2.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	Teacher findById(int tid);
}
