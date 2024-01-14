package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public Student addStudent(Student student) {
		
	return	studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
	   return studentRepo.findAll();
		
	}

	public Student updateStudent(Student student) {
		return studentRepo.save(student);
		
	}

	public Student findStudentById(Long id) {
		 Optional<Student> findById = studentRepo.findById(id);
		 if (findById.isPresent()) {
			return findById.get();
		}
		 else {
			 return null;
		 }
		
	}
	public Student deleteStudentById(Long id) {
		Student student=findStudentById(id);
		studentRepo.deleteById(id);
		return student;
		
	}

	

}
