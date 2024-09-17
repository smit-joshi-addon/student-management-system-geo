package com.students.app.service;

import java.util.List;

import org.locationtech.jts.io.ParseException;

import com.students.app.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student addStudent(String name,String phone,String lattitude,String longitude) throws ParseException ;

	Student updateStudent(Student student, Long studentId);

	Student findStudentById(Long studentId);

	void removeStudent(Long studentId);

}
