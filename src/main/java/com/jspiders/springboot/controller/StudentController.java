package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "/student")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addStudent = studentService.addStudent(student);
		StudentResponse studentResponse=new StudentResponse();
		studentResponse.setMessage("Student Added..");
		studentResponse.setStudent(addStudent);
		studentResponse.setStudents(null);
		studentResponse.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/students")
	public ResponseEntity<StudentResponse> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		if (allStudents!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Student Found..");
			studentResponse.setStudent(null);
			studentResponse.setStudents(allStudents);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.FOUND);
			
		}
		else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Student Not Found..");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.NOT_FOUND);
			
		}
		
	}
	@PutMapping(path="/student")
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student) {
		Student updateStudent = studentService.updateStudent(student);
		StudentResponse studentResponse=new StudentResponse();
		studentResponse.setMessage("Student Upadated..");
		studentResponse.setStudent(updateStudent);
		studentResponse.setStudents(null);
		studentResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}
	
	@GetMapping(path="/student")
	public ResponseEntity<StudentResponse> FindStudentById(@RequestParam long id){
		    Student findStudentById = studentService.findStudentById(id);
		    if (findStudentById!=null) {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student Found..");
				studentResponse.setStudent(findStudentById);
				studentResponse.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.FOUND);
				
			}
			else {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student Not Found..");
				studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.NOT_FOUND);
				
			}
	}
	
	
	
	@DeleteMapping(path="/student/{id}")
	public ResponseEntity<StudentResponse> deleteStudentById(@PathVariable long id){
		Student deleteStudentById = studentService.deleteStudentById(id);
		StudentResponse studentResponse=new StudentResponse();
		studentResponse.setMessage("Student Deleted..");
		studentResponse.setStudent(deleteStudentById);
		studentResponse.setStudents(null);
		studentResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
		
	}

}
