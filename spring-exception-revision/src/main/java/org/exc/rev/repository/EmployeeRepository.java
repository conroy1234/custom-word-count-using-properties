package org.exc.rev.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.exc.rev.model.Employee;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository {

	public List<Employee> employees = new ArrayList<Employee>();

	public static List<Employee> findAll() {
		employees.add(new Employee(1, "Tom Baile", "Manager", "11 Peal road Wembley", new BigDecimal(55800.90)));
		employees
				.add(new Employee(2, "Steve Thomas", "Supervisor", "14 Bevil Drive Swindon", new BigDecimal(45800.90)));
		employees.add(new Employee(3, "Jane Teal", "Customer Service", "11 Plumtree close Dagenham",
				new BigDecimal(25800.90)));
		employees.add(
				new Employee(4, "Timothy Watson", "Shop attendant", "Dane Close Dagenham", new BigDecimal(25800.90)));

		return employees;
	}

	public static List<Employee> findById(int id) {

		return employees.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
	}

	public static Employee getById(Integer id) {
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

	public static Employee save(Employee employee) {
		employee.setId(employees.size() + 1);
		employees.add(employee);

		return employee;
	}

}
