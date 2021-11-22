package com.mindex.challenge.data;

public class Compensation {

	private Employee employee;
	private int salary;
	private String effectiveDate;

	public Compensation() {

	}

	public Compensation(Employee employee, int salary, String effectiveDate) {
		super();
		this.employee = employee;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	

}
