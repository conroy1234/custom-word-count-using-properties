package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;

@Service
public class TodoService {
	
	private static int id;
	private static List<Todo> todos;
	
	static{
		todos = new ArrayList<>();
		todos.add(new Todo(++id,"the test",true,new Date()));
		todos.add(new Todo(++id,"the second",true,new Date()));
		todos.add(new Todo(++id,"the third",true,new Date()));
		todos.add(new Todo(++id,"the fourth",true,new Date()));
	}
	
	public List<Todo> findAll(){
		return todos;
	}

}
