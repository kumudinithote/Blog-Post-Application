package com.sampleUI.first.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends MongoRepository<Student, String>{
	public Student findByEmailAllIgnoreCase(String email);
	public List<Student> findByFirstNameAllIgnoreCase(String firstName);
	public Student findByEmailAndPassword(String email, String password);
}