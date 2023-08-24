package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	public String addStudent(Student student) {
		dao.save(student);
		return "New student has been added"+student.getRoll();
	}
	
//	public String addStudent(List<Student> student) {
//		dao.saveAll(student);
//		return "All students added";
//	}
	
	public String deleteStudent(int roll) {
		Student student = dao.getReferenceById(roll);
		dao.delete(student);
		return "Roll number is deleted"+roll;
	}
	
	public String updateStudent(Student student) {
		dao.save(student);
		return "Roll number updated"+student.getRoll();
	}
	
	public Optional<Student> getStudent(int roll) {
		return dao.findById(roll);
	}
	
	//SAVE
	public Student saveStudent(Student student) {
		dao.save(student);
		return student;
	}
	
	
}
