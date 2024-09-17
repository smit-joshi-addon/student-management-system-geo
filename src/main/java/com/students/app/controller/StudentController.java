package com.students.app.controller;

import java.util.List;

import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.app.entities.Student;
import com.students.app.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@PostMapping("add")
	public ResponseEntity<Student> addStudent(@RequestParam String name,@RequestParam String phone, @RequestParam String latitude, @RequestParam String longitude) throws ParseException {	
		return ResponseEntity.ok(studentService.addStudent(name,phone,latitude,longitude));
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.findStudentById(id));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Student> updateUser(@RequestBody Student student, @PathVariable Long id) {
		return ResponseEntity.ok(studentService.updateStudent(student, id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
		studentService.removeStudent(id);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
