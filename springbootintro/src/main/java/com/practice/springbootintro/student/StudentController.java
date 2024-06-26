package com.practice.springbootintro.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerStudent(@RequestBody Student student) {
		studentService.registerStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping(path="/{id}")
	public void updateStudent(@PathVariable("id") int id, @RequestParam(required=false) String firstName, @RequestParam(required=false) String lastName) {
		studentService.updateStudent(id, firstName, lastName);
	}

}
