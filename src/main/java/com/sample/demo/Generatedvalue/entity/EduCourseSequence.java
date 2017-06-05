package com.sample.demo.Generatedvalue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "Edu_Course_GenerationType_seq")
public class EduCourseSequence {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(
		name="course_seq",
		sequenceName="course_sequence",
		allocationSize=20
	)
	private int id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "duration")
	private int duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
