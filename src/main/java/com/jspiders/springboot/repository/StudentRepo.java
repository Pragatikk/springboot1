package com.jspiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.pojo.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
