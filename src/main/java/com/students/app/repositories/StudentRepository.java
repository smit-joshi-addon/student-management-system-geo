package com.students.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.app.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
