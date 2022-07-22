package com.skillstorm.data;
import java.lang.Math; 
//import static java.lang.Math.PI; references only PI 

public class Student { //top-level classes can only be public or default
	private boolean enrolled;
	private int studentId;
	private String name;
	private char grade;
	private int age;
	
	//getters/setters
	
	//JavaBeans - 1/encapsulated 2/noargument constructor 3/ set/get naming convention
	public void setAge(int age) {
		if (age>=0) {
			this.age=age;
		}
	}
	public int getAge() {
		return age;
	}
	public boolean isEnrolled() {
		return enrolled;
	}
	public void setEnrolled(boolean enrolled) {
		this.enrolled = enrolled;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade=grade;
	}
	
}
