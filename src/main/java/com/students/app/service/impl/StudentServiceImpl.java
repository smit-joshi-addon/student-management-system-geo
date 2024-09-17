package com.students.app.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.app.entities.Student;
import com.students.app.repositories.StudentRepository;
import com.students.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student addStudent(String name,String phone,String lattitude,String longitude) throws ParseException {
		WKTReader wktReader = new WKTReader();
		Geometry geometry = wktReader.read("POINT (+" + lattitude + " " + longitude + ")");
		
		Student student = new Student();
		student.setName(name);
		student.setPhone(phone);
		student.setGeom(geometry);
		
		studentRepository.save(student);
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, Long studentId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		studentOptional.ifPresent(s -> {
			if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
				s.setName(student.getName());
			}
			if (Objects.nonNull(student.getPhone()) && !"".equalsIgnoreCase(student.getPhone())) {
				s.setPhone(student.getPhone());
			}
		});
		return studentRepository.save(studentOptional.get());
	}

	@Override
	public Student findStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public void removeStudent(Long studentId) {
		
		studentRepository.deleteById(studentId);

	}

}
