package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//CREATE A STUDENT
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		//service class method
		return studentService.addStudent(student);
	}
	
//	@PostMapping("/bulkAdd")
//	public String addStudents(@RequestBody List<Student> students) {
//		//service class method
//		return studentService.addStudents(students);
//	}
	
	//DELETE
	@DeleteMapping("/all/{roll}")
	public String deleteStudent(@PathVariable int roll) {
		return studentService.deleteStudent(roll);
	}
	
	//UPDATE
	@PutMapping("/add")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	//READ A STUDENT
	@RequestMapping("/all/{roll}")
	public Optional<Student> getStudent(@PathVariable int roll) {
		return studentService.getStudent(roll);
	}
	
	//PATCH OPERATION
		@PatchMapping("patchStudent/{roll}")
		public ResponseEntity<Student> patchEmployee(@PathVariable int roll, @RequestBody Student student){
			Optional <Student> stud = studentService.getStudent(roll);
			stud.get().setName(student.getName());
			stud.get().setCity(student.getCity());
			Student empRespo = studentService.saveStudent(stud.get()) ;
			
			ResponseEntity<Student> re = new ResponseEntity<>(empRespo, HttpStatus.OK);
			return re;
		}	
}
