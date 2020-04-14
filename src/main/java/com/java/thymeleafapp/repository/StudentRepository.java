package com.java.thymeleafapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.thymeleafapp.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
