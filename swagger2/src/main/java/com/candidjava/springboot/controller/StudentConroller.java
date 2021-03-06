package com.candidjava.springboot.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swaggerExample.models.Student;
import swaggerExample.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentConroller {
	@Autowired
	StudentService service;

	@PostMapping("/create")
	public void create(@Valid @RequestBody Student student) {
		service.createStudent(student);
	}

	@GetMapping("/getAll")
	public List<Student> get() {
		return service.getAllStudents();
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable("id") String id) {
		return service.getStudentById(id);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") String id, @Valid @RequestBody Student student) {
		service.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.service.deleteStudentById(id);
	}
}