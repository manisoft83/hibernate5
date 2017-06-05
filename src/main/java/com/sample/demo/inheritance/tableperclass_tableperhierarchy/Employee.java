package com.sample.demo.inheritance.tableperclass_tableperhierarchy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
@DiscriminatorValue("E")
public class Employee extends Person {
	Employee(){}
	public Employee(String firstname, String lastname,String departmentName, Date joiningDate) {
		super(firstname, lastname);
		this.joiningDate = joiningDate;
		this.departmentName = departmentName;
	}

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
}