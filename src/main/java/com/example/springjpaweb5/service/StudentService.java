package com.example.springjpaweb5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springjpaweb5.model.Student;


@Service
public interface StudentService {
	List<Student> all();

    Student save(Student student);

    void delete(String studentId);
	
}