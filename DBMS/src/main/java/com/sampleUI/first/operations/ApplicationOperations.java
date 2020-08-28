package com.sampleUI.first.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sampleUI.first.accessingdatamongodb.Story;
import com.sampleUI.first.accessingdatamongodb.StoryRepository;
import com.sampleUI.first.accessingdatamongodb.Student;
import com.sampleUI.first.accessingdatamongodb.StudentRepository;

@Component
public class ApplicationOperations{
	
	@Autowired
	private Student student;
	
	@Autowired
	private Story story;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StoryRepository storyRepository;
	
	
	public Student validateUser(String email, String password){
		
		student = studentRepository.findByEmailAndPassword(email, password);
		return student;
	}
	
	public boolean validateEmailAddress(String email){
		student = studentRepository.findByEmailAllIgnoreCase(email);
		return student != null ? true : false;		
	}
	
	public void createNewUser(String email, String password, String firstName, String lastName){
		studentRepository.save(new Student(email, firstName, lastName, password));		
	}
	
	public List<Story> postNewBlog(String blogTitle, String email, String genre, String story){
		storyRepository.save(new Story(blogTitle, email, genre, story));
		
		return storyRepository.findByEmailOrderByPublishedOnDescAllIgnoreCase(email);	
	
	}
	
	public List<Story> updateBlog(String id, String blogTitle, String email, String genre, String story){
		List<String> upvotes = storyRepository.findById(id).upvotes;
		storyRepository.save(new Story(id, blogTitle, email, genre, story, upvotes));
		
		return storyRepository.findByEmailOrderByPublishedOnDescAllIgnoreCase(email);	
	
	}
	
	public void updateUserWithFollowers(Student student, List<String> followers){
		studentRepository.save(new Student(student, followers));		
	}
	
	public void updateUserWithFollowings(List<String> followings, Student student){
		studentRepository.save(new Student(followings, student));		
	}
	
	public List<Story> viewBlogs(String email){
		return storyRepository.findByEmailOrderByPublishedOnDescAllIgnoreCase(email);	
	}
	
	public List<Story> viewBlogsByGenre(String genre){
		return storyRepository.findByGenreOrderByPublishedOnDescAllIgnoreCase(genre);	
	}
	
	public List<Story> viewBlogsByBlogTitle(String blogTitle){
		return storyRepository.findByBlogTitleContainingOrderByPublishedOnDescAllIgnoreCase(blogTitle);	
	}

	public Story findBlogs(String id) {
		return storyRepository.findById(id);
	}

	public Student searchUserByEmail(String email) {
		student = studentRepository.findByEmailAllIgnoreCase(email);
		
		return student;
	}

	public List<Student> searchUserByFirstName(String firstName) {
		return studentRepository.findByFirstNameAllIgnoreCase(firstName);
	}

	public void upvoteBlog(Story story) {
		storyRepository.save(new Story(story));
		
	}
	
	
}
