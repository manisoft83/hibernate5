package com.sample.demo.Generatedvalue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "Edu_Course_GenerationType_table")
public class EduCourseTable {
	@Id
	/*@GeneratedValue(strategy=GenerationType.TABLE, generator="course")
	@TableGenerator(
		    name="course",
		    table="GENERATOR_TABLE",
		    pkColumnName = "key",
		    valueColumnName = "next",
		    pkColumnValue="course",
		    allocationSize=30
		)*/
	@GenericGenerator(name = "table", strategy = "enhanced-table", parameters = {
            @org.hibernate.annotations.Parameter(name = "table_name", value = "EduCourse_sequence_table")
    })
    @GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
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
