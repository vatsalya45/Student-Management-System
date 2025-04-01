package com.vatsalya.add_student;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBean implements Serializable
{
	private String rollno,name,course,result;
	private int totalMarks;
	private float percentage;
	private MarksBean mk = new MarksBean();
	
	public StudentBean () {}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public MarksBean getMk() {
		return mk;
	}
	public void setMk(MarksBean mk) {
		this.mk = mk;
	}
	
	
}
