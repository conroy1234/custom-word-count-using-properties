package org.exc.rev.model;

import java.math.BigDecimal;

public class Employee {

	private Integer id;
	private String name;
	private String position;
	private String address;
	private BigDecimal salary;

	public Employee() {

	}

	public Employee(Integer id,String name, String position, String address, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.address = address;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", address=" + address + ", salary="
				+ salary + "]";
	}

}
