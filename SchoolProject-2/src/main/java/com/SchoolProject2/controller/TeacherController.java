package com.SchoolProject2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolProject2.entity.Teacher;
import com.SchoolProject2.exception.TeacherNotFoundException;
import com.SchoolProject2.service.TeacherService;

import jakarta.validation.Valid;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService tservice;
	
	@PostMapping("/teacher/signup")
	public ResponseEntity<Teacher> saveUser(@RequestBody @Valid Teacher teacher){
		return new ResponseEntity<>(tservice.saveTeacher
				(teacher),HttpStatus.CREATED);	
	}
	
	@GetMapping("/teacher/findAll")
	public ResponseEntity<List<Teacher>> getAllTeacherInfo() {
        return ResponseEntity.ok(tservice.getALLTeacher());
	}
	
	@GetMapping("/teacher/find/{tid}")
	public ResponseEntity<Teacher> getUser(@PathVariable int tid) throws TeacherNotFoundException {
		return ResponseEntity.ok(tservice.getTeacher(tid));	 
	}
	
	@PutMapping("/teacher/editTeacher/{tid}")
	public ResponseEntity<Teacher> editTeacher(@Valid @PathVariable("tid") int tid, @RequestBody Teacher teacher){
		return new ResponseEntity<Teacher>(tservice.updateTeacherDetail(teacher, tid), HttpStatus.OK);
	}
	
	@DeleteMapping("teacher/deleteTeacher/{tid}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("tid") int tid){
		tservice.deleteTeacherDetail(tid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
}
