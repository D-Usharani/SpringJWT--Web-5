package com.example.springjpaweb5.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpaweb5.model.Student;
import com.example.springjpaweb5.service.StudentService;


@RestController
public class StudentController implements StudentService {

	private StudentService studentService;

	public StudentController(@Autowired StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/api/student")
	public List<Student> all() {
		return (List<Student>) studentService.all();

	}

	@PostMapping("/api/student")
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}

	@DeleteMapping("/api/student/{id}")
	public void delete(@PathVariable String id) {
		studentService.delete(id);

	}

	

}