package com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grades")
public class Grades {

	@Id
	private long id;
	
	private String first_name;
	private String last_name;
	private String ssn;
	private double test1;
	private double test2;
	private double test3;
	private double test4;
	private double final_test;
	private String grade;
	
	public Grades() {
		
	}

	public Grades(long id, String first_name, String last_name, String ssn, double test1, double test2, double test3,
			double test4, double final_test, String grade) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.ssn = ssn;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;
		this.final_test = final_test;
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getSsn() {
		return ssn;
	}

	public double getTest1() {
		return test1;
	}

	public double getTest2() {
		return test2;
	}

	public double getTest3() {
		return test3;
	}

	public double getTest4() {
		return test4;
	}

	public double getFinal_test() {
		return final_test;
	}

	public String getGrade() {
		return grade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setTest1(double test1) {
		this.test1 = test1;
	}

	public void setTest2(double test2) {
		this.test2 = test2;
	}

	public void setTest3(double test3) {
		this.test3 = test3;
	}

	public void setTest4(double test4) {
		this.test4 = test4;
	}

	public void setFinal_test(double final_test) {
		this.final_test = final_test;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grades [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", ssn=" + ssn
				+ ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3 + ", test4=" + test4 + ", final_test="
				+ final_test + ", grade=" + grade + "]";
	}

	
	
}
