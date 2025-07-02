package com.codeD.springorm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_tab")
public class StudentEntity {
	
	@Id
	private int student_id;

	@Column
	private String student_name;

	@Column
	private String student_address;
	
	
	//default- constructor
	public StudentEntity() {
		super();
	}
	
	//parameterized constructor
	public StudentEntity(int student_id, String student_name, String student_address) {
	
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_address = student_address;
	}
	
	//getters and setters
	public int getstudent_id() {
		return student_id;
	}
	public void setstudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getstudent_name() {
		return student_name;
	}
	public void setstudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getstudent_address() {
		return student_address;
	}
	public void setstudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	@Override
	public String toString() {
		return "studentEntity [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + "]";
	}
}	
