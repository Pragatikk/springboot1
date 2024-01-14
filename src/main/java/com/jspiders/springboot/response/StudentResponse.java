package com.jspiders.springboot.response;

import java.util.List;

import com.jspiders.springboot.pojo.Student;

import lombok.Data;

@Data
public class StudentResponse {

	private String message;
	private int status;
	private Student student;
	private List<Student> students;

	

}
