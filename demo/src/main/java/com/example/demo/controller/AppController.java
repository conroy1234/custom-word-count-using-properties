package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AppController {
 
	@Autowired
	TodoService todoService;
	
	@GetMapping("/the-service")
	public List<String> getHello() {
		return Arrays.asList("hellow world","hello girl","live in london");
	}
	
	@GetMapping("/the-service/{name}")
	public List<String> getHelloWithPathVariable(@PathVariable String name) {
		return Arrays.asList("hellow world "+name,"hello girl","live in london");
	}
	
	@GetMapping("/fild/all/todos/service")
	public List<Todo> findAll(){
		return todoService.findAll();
	}
}
