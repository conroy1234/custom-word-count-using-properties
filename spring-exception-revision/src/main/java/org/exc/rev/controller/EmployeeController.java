package org.exc.rev.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.exc.rev.exception.EmployeeNotFoundException;
import org.exc.rev.model.Employee;
import org.exc.rev.model.TestingBeanConfig;
import org.exc.rev.model.testingBean;
import org.exc.rev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	TestingBeanConfig sonfig;

	@GetMapping("/employee/app")
	public List<Employee> findAll() {
		return employeeService.findAll();

	}

	@GetMapping("/employee/app-lambda/{id}")
	public List<Employee> findById(@Valid @PathVariable int id) {
		List<Employee> employees = employeeService.findByid(id);
		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException("connoy find employee with Id " + id);
		}
		return employees;

	}

	@GetMapping("/employee/app/{id}")
	public Employee getById(@PathVariable int id) {
		employeeService.findAll().stream().filter(e -> {
			if (employeeService.findAll().get(id)==null) {
				throw new EmployeeNotFoundException("connoy find employee with Id " + id);
			}
			return e.getId() == id;
		}).collect(Collectors.toList());

		return employeeService.getById(id);

	}

	@PostMapping("/employee/app")
	public ResponseEntity<String> save(@RequestBody Employee employee) {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(employee.getId()).toUri();
		employeeService.save(employee);

		return new ResponseEntity<String>(location + "/" + employee.getId(), HttpStatus.CREATED);

	}
	
	@GetMapping("max/min/config/mappings")
	public testingBean bean() {
		return new testingBean(sonfig.getMaxnumber(), sonfig.getMinnumber());
	}

}
