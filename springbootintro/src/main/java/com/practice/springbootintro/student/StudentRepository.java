package com.practice.springbootintro.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//	@Query("SELECT s FROM Student s WHERE s.id = ?1")
	public Optional<Student> findStudentById(int id);
	
}
