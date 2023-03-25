package com.example.springjpaweb5.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.springjpaweb5.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	private Map<String, Student> students = new HashMap<>();

	@Override
	public List<Student> all() {
		return new ArrayList<>(students.values());
	}

	@Override
	public Student save(Student student) {
	students.put(student.getId(), student);
	return student;
	}

	@Override
	public void delete(String studentId) {
		students.remove(studentId);
	}
}