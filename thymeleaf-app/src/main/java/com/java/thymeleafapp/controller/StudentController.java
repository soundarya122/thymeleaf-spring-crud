package com.java.thymeleafapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.thymeleafapp.model.Student;
import com.java.thymeleafapp.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/all")
	public String getAll(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer Id) {
		return studentService.getOne(Id);
	}
	
	@PostMapping("/addNew")
	public String addNew(Student student) {
		studentService.addNew(student);
		return "redirect:/students/all";
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student) {
		studentService.update(student);
		return "redirect:/students/all";		
	}
	
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		studentService.delete(Id);
		return "redirect:/students/all";		
	}
}
