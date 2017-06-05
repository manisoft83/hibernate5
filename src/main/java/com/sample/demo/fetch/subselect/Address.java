package com.sample.demo.fetch.subselect;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="ADDRESS_FETCH")
 
public class Address implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;
     
    @Column(name="FIRST_LINE")  
    private String firstLine  = null;
    @Column(name="SECOND_LINE")
    private String secondLine = null;
    @Column(name="CITY")
    private String city       = null;
    @Column(name="ZIP_CODE")
    private String zipCode    = null;
    @ManyToOne
    @JoinColumn(name="PERSON_ID")   
    private Person person     = null;
     
    @Column(name="PERSON_ID", insertable=false, updatable=false)
    private Integer personId = null;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFirstLine() {
        return firstLine;
    }
     
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }
     
    public String getSecondLine() {
        return secondLine;
    }
     
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }
     
    public String getCity() {
        return city;
    }
     
    public void setCity(String city) {
        this.city = city;
    }
     
    public String getZipCode() {
        return zipCode;
    }
     
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
 
    public Person getPerson() {
        return person;
    }
     
    public void setPerson(Person person) {
        this.person = person;
    }
     
    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Address ******");
        sb.append("\n");
        sb.append("Id: ");
        sb.append(this.id);
        sb.append("\n");
        sb.append("First Line: ");
        sb.append(this.firstLine);
        sb.append("\n");
        sb.append("Second Line: ");
        sb.append(this.secondLine);
        sb.append("\n");
        sb.append("City: ");
        sb.append(this.city);
        sb.append("\n");
        sb.append("Zip Code: ");
        sb.append(this.zipCode);
        sb.append("\n");
        sb.append("Person Id: ");
        sb.append(this.personId);
        sb.append("\n");
        sb.append("***** Address ******");
        sb.append("\n");
         
        return sb.toString();
 
    }
     
}
