package com.sample.demo.immutable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * @author ab65239
 * If mutable = “false” or @Immutable is declared in collection, it means the add and delete-orphan are not allow in this collection, 
 * 		with exception throw, only update and ‘cascade delete all’ are allow.
 *
 */
@Entity
@Table(name="contact_number")
@Immutable
public class ContactNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column(name="person_id")
	private int personId;
	@Column(name="mobile_number")
	String mobileNumber;
	public ContactNumber(int id,int personId,String mobileNumber){
		this.id=id;
		this.personId=personId;
		this.mobileNumber=mobileNumber;
	}
	public ContactNumber(){	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
} 
