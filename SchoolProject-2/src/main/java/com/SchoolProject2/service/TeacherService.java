package com.SchoolProject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolProject2.entity.Teacher;
import com.SchoolProject2.exception.StudentNotFoundException;
import com.SchoolProject2.exception.TeacherNotFoundException;
import com.SchoolProject2.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository trepo;
  	public List<Teacher> getALLTeacher() {
        return trepo.findAll();
    }
  	public Teacher saveTeacher(Teacher teacher) {
  		Teacher teacher1 =Teacher.build(0, teacher.getTname(), teacher.getTsurname(),
  				teacher.getTemail(), teacher.getTphone(), teacher.getDesignation(), teacher.getStudent());
  		return trepo.save(teacher1); 		
  	}
  	
  	public Teacher getTeacher(int tid) throws TeacherNotFoundException{
  		Teacher teacher=trepo.findById(tid);
  		if(teacher!=null) {
  			return teacher;
  		}
  		else
  			throw new TeacherNotFoundException("Teacher not found with id:"+tid);
    }
  	
  	public Teacher getStudent(int sid) throws StudentNotFoundException{
  		Teacher student=trepo.findById(sid);
  		if(student!=null) {
  			return student;
  		}
  		else
  			throw new StudentNotFoundException("Student not found with id:"+sid);
    }
	public Teacher updateTeacherDetail(Teacher teacher, int tid) {
		Teacher updatedTeacher = trepo.findById(tid);
		if(updatedTeacher!=null) {
		updatedTeacher.setTphone(teacher.getTphone());
		updatedTeacher.setDesignation(teacher.getDesignation());
		trepo.save(updatedTeacher);
		}
	return updatedTeacher;
	}
	
	public void deleteTeacherDetail(int tid) {
  		Teacher teacher=trepo.findById(tid);
  		if(teacher!=null) {
  		    trepo.deleteById(tid);
  		}
    }
}