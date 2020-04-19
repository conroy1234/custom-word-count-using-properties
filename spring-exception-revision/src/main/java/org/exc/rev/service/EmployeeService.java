package org.exc.rev.service;

import java.util.List;

import org.exc.rev.model.Employee;
import org.exc.rev.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
//	
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
	List<Employee> employees = EmployeeRepository.findAll();
	
	public List<Employee> findAll(){
		return employees;		
	}
	
	public List<Employee> findByid(int id){
		return EmployeeRepository.findById(id);
		
	}
	
	public Employee getById(Integer id) {
		return EmployeeRepository.getById(id);
		
	}
	
	public Employee save(Employee employee) {
		return EmployeeRepository.save(employee);
		
	}
	
}
