package com.sampleUI.first.accessingdatamongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Id
    public String id;
	
	public String email;
    public String firstName;
    public String lastName;
    public String password;
    public List<String> followers;
    public List<String> followings;

    public Student() {}
    
    public String getEmail() {
        return email;
    }  
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public List<String> getFollowers() {
        return followers;
    }
    
    public List<String> getFollowing() {
        return followings;
    }
    

    public Student(String email, String firstName, String lastName, String password) {
    	this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.followers = new ArrayList<String>();
        this.followings = new ArrayList<String>();
        this.followings.add(email);
    }
    
    public Student(Student student, List<String> followers) {
    	this.id = student.id;
    	this.firstName = student.firstName;
    	this.lastName = student.lastName;
    	this.password = student.password;
    	this.email = student.email;
    	this.followings = student.followings;
        this.followers = followers;
    }
    
    public Student(List<String> followings, Student student) {
    	this.id = student.id;
    	this.firstName = student.firstName;
    	this.lastName = student.lastName;
    	this.password = student.password;
    	this.email = student.email;
    	this.followers = student.followers;
        this.followings = followings;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%s, rollNo = '%s', firstName='%s', lastName='%s', password='%s']",
                id, email, firstName, lastName, password);
    }
}