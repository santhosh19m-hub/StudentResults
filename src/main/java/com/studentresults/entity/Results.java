package com.studentresults.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Results {
@Id	
private int id;
	private String name;
	private int rollNumber;
	private int totalMarks;
	private int percentage;
	
	
	public Results() {
		super();
	}
	
	public Results(int id, String name, int rollNumber, int totalMarks, int percentage) {
		super();
		this.id = id;
		this.name = name;
		this.rollNumber = rollNumber;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
