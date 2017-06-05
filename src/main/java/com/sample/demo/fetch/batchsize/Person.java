package com.sample.demo.fetch.batchsize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="PERSON_FETCH",
        schema="SYSTEM")
public class Person implements Serializable {
 
    private static final long serialVersionUID = 4333499410830154895L;
 
    private int id = 0;
    private String firstName = null;
    private String lastName = null;
 
    private List<Address> addresses = new ArrayList<Address>();
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @OneToMany(mappedBy="person", cascade=CascadeType.ALL)
    @Column(name="id")
    @BatchSize(size = 2)
    public List<Address> getAddresses() {
        return addresses;
    }
 
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
     
    public void addAddress(Address address) {
        address.setPerson(this);
        this.addresses.add(address);
         
    }
     
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("**** Person **** ");
        sb.append("Id: ");
        sb.append(this.id);
        sb.append("\n");
        sb.append("First name: ");
        sb.append(this.firstName);
        sb.append("\n");
        sb.append("Last name: ");
        sb.append(this.lastName);
        sb.append("\n");
        sb.append("**** Person **** ");
        sb.append("\n");
         
        return sb.toString();
    }
     
}
