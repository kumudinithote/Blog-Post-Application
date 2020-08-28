package com.sampleUI.first.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sampleUI.first.accessingdatamongodb.Story;
import com.sampleUI.first.accessingdatamongodb.StoryRepository;
import com.sampleUI.first.accessingdatamongodb.Student;
import com.sampleUI.first.accessingdatamongodb.StudentRepository;
import com.sampleUI.first.operations.ApplicationOperations;


@SuppressWarnings("unused")
@Controller
public class HelloController {
	
	@Autowired
	private ApplicationOperations operation;
	
	@Autowired
	Student student;
	
	@Autowired
	Story story;
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public String emailAddress;
	
	public List<Story> stories;
	
   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/login")
   public ModelAndView sayHello(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	  this.emailAddress = email;
      student = operation.validateUser(email, password);
      if(student != null){
    	  
    	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
    	  Comparator<Story> comparator = new Comparator<Story>(){
    		  
              public int compare(Story st1, Story st2) {
                   if(st1.getPublishedOn().after(st2.getPublishedOn()))
                		   return -1;
                   else if (st1.getPublishedOn().before(st2.getPublishedOn()))
                		   return 1;
                   else
                	   return 0;
              }

          };
          
          List<Story> stories = new ArrayList<Story>();
          for(int i = 0; i < currentStudent.followings.size(); i++){
        	  List<Story> temp = operation.viewBlogs(currentStudent.followings.get(i));
        	  stories.addAll(stories.size(), temp);
          }
          Collections.sort(stories, comparator);
    	  
    	  model.addAttribute("firstName", currentStudent.firstName);
    	  model.addAttribute("followers", currentStudent.followers);
    	  model.addAttribute("followings", currentStudent.followings);
    	  
		  return new ModelAndView("login", "stories", stories);
      }else{
    	  return new ModelAndView("index", "Message", "UserId and password doesn't match");
      }
   }
   
   @PostMapping("/home")
   public ModelAndView homePage(Model model) {

    	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
    	  Comparator<Story> comparator = new Comparator<Story>(){
    		  
              public int compare(Story st1, Story st2) {
                   if(st1.getPublishedOn().after(st2.getPublishedOn()))
                		   return -1;
                   else if (st1.getPublishedOn().before(st2.getPublishedOn()))
                		   return 1;
                   else
                	   return 0;
              }

          };
          
          List<Story> stories = new ArrayList<Story>();
          for(int i = 0; i < currentStudent.followings.size(); i++){
        	  List<Story> temp = operation.viewBlogs(currentStudent.followings.get(i));
        	  stories.addAll(stories.size(), temp);
          }
          Collections.sort(stories, comparator);
    	  
    	  model.addAttribute("firstName", currentStudent.firstName);
    	  model.addAttribute("followers", currentStudent.followers);
    	  model.addAttribute("followings", currentStudent.followings);
		  return new ModelAndView("login", "stories", stories);
	 
}
   
   @RequestMapping("/registration")
   public String registration() {
      return "registration";
   }
   
   @RequestMapping("/postBlog")
   public String postBlog() {
      return "postBlog";
   }
   
   
   @RequestMapping("/registerUser")
   public String homePage(@RequestParam("email") String email, @RequestParam("password") String password,
		   @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Model model) {
	  boolean validate = operation.validateEmailAddress(email);
	  if(validate){
		  model.addAttribute("Message", "User already exist and please login");
	  }else{
		  operation.createNewUser(email, password, firstName, lastName);
		  model.addAttribute("Message", "Registration successful, please login");
	  }
	  return "index";
   }
   
   @RequestMapping("/updateBlog")
   public String updateBlog(@RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("story") String story,
		   @RequestParam("genre") String genre, Model model) {
	   
	  stories = operation.updateBlog(id, title, this.emailAddress, genre, story);
	  model.addAttribute("ListBlogs", stories);
      return "viewBlogs";
   }
   
   @RequestMapping("/publishBlog")
   public String publishBlog(@RequestParam("title") String title, @RequestParam("story") String story,
		   @RequestParam("genre") String genre, Model model) {
	   
	  stories = operation.postNewBlog(title, this.emailAddress, genre, story);
	  model.addAttribute("ListBlogs", stories);
      return "viewBlogs";
   }
   
   @RequestMapping("/viewBlogs")
   public ModelAndView viewBlogs(Model model) {
	  
	  stories = operation.viewBlogs(this.emailAddress);
	  model.addAttribute("ListBlogs", stories);
	  return new ModelAndView("viewBlogs", "ListBlogs", stories);
   }
   
   @RequestMapping("/deleteBlog")
   public ModelAndView deleteBlog(@RequestParam("id") String id, Model model) {
	  
	  storyRepository.deleteById(id);  
	  List<Story> listBlogs = operation.viewBlogs(this.emailAddress);
	  model.addAttribute("ListBlogs", listBlogs);
	  
	  return new ModelAndView("viewBlogs", "ListBlogs", listBlogs);
	  
   }
   
   @RequestMapping("/findByGenre")
   public ModelAndView findByGenre(@RequestParam("genre") String genre, Model model) {
	   
	  List<Story> listBlogs = operation.viewBlogsByGenre(genre);
	  model.addAttribute("ListBlogs", listBlogs);
	  
	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	  model.addAttribute("firstName", currentStudent.firstName);
	  model.addAttribute("followers", currentStudent.followers);
	  model.addAttribute("followings", currentStudent.followings);
	  
	  return new ModelAndView("searchedBlogs", "ListBlogs", listBlogs);
	  
   }
   
   @RequestMapping("/findByTitle")
   public ModelAndView findByTitle(@RequestParam("blogTitle") String blogTitle, Model model) {
	   
	  List<Story> listBlogs = operation.viewBlogsByBlogTitle(blogTitle);
	  model.addAttribute("ListBlogs", listBlogs);
	  
	  
	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	  model.addAttribute("firstName", currentStudent.firstName);
	  model.addAttribute("followers", currentStudent.followers);
	  model.addAttribute("followings", currentStudent.followings);
	  return new ModelAndView("searchedBlogs", "ListBlogs", listBlogs);
	  
   }
   
   @RequestMapping("/trending")
   public ModelAndView trendingStories(Model model) {
	   
	  List<Story> listBlogs = storyRepository.findAll();
	  
	  Comparator<Story> upvotesComparator = new Comparator<Story>() {
          @Override
          public int compare(Story s1, Story s2) {
              return s2.upvotes.size() - s1.upvotes.size();
          }
      };
	  PriorityQueue<Story> stories = new PriorityQueue<>(5, upvotesComparator);
	  
	  for(int i = 0; i < listBlogs.size(); i++){
		  stories.add(listBlogs.get(i));
	  }
	  
	  model.addAttribute("ListBlogs", listBlogs);
	  
	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	  model.addAttribute("firstName", currentStudent.firstName);
	  model.addAttribute("followers", currentStudent.followers);
	  model.addAttribute("followings", currentStudent.followings);
	  return new ModelAndView("searchedBlogs", "ListBlogs", stories);
	  
   }
   
   @RequestMapping("/editStory")
   public ModelAndView editBlog(@RequestParam("id") String id, Model model) {
	   
	  Story story = operation.findBlogs(id);
	  model.addAttribute("Story", story);
	  
	  return new ModelAndView("editBlog", "ListBlogs", story);
	  
   }
   
   @RequestMapping("/showStory")
   public ModelAndView showBlog(@RequestParam("id") String id, Model model) {
	   
	  Story story = operation.findBlogs(id);
	  model.addAttribute("Story", story);
	  
	  return new ModelAndView("viewSelectedBlog", "ListBlogs", story);
	  
   }
   
   @RequestMapping("/upvoteStory")
   public ModelAndView upvoteBlog(@RequestParam("id") String id, Model model) {
	   
	  Story story = operation.findBlogs(id);
	  if(!story.upvotes.contains(this.emailAddress)){
		  story.upvotes.add(this.emailAddress);
		  operation.upvoteBlog(story);
	  }
		  
	  model.addAttribute("Story", story);
	  
	  return new ModelAndView("viewSelectedBlog", "ListBlogs", story);
	  
   }
   
   @RequestMapping("/searchUserByEmail")
   public ModelAndView searchUserByEmail(@RequestParam("email") String email, Model model) {
	   
	   Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	   model.addAttribute("firstName", currentStudent.firstName);
	   model.addAttribute("followers", currentStudent.followers);
	   model.addAttribute("followings", currentStudent.followings);
	   
	  Student student = operation.searchUserByEmail(email);
	  List<Student> users = new ArrayList<Student>();
	  users.add(student);
	  
	  if(student == null){
		  String message = "No user found by given email, please try with correct one";
		  return new ModelAndView("login", "Message", message);
	  }else
		  return new ModelAndView("login", "Users", users);	  
   }
   
   @RequestMapping("/searchUserByFirstName")
   public ModelAndView searchUserByfirstName(@RequestParam("firstName") String firstName, Model model) {
	   Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	   model.addAttribute("firstName", currentStudent.firstName);
	   model.addAttribute("followers", currentStudent.followers);
	   model.addAttribute("followings", currentStudent.followings);
	   
	  List<Student> users = operation.searchUserByFirstName(firstName);
	  
	  if(users.size() == 0){
		  String message = "No user found by given firstName, please try with correct one";
		  return new ModelAndView("login", "Message", message);
	  }else
		  return new ModelAndView("login", "Users", users);	  
   }
   
   @RequestMapping("/visitStudent")
   public ModelAndView visitStudent(@RequestParam("email") String email, Model model) { 
	  stories = operation.viewBlogs(email);
	  student = operation.searchUserByEmail(this.emailAddress);
	  if(student.followings.contains(email)){
		  model.addAttribute("unfollowEmail", email);
	  }else
	  {
		  model.addAttribute("followEmail", email);
	  }
	  
	  return new ModelAndView("viewOtherBlogs", "ListBlogs", stories);
   }
   
   @RequestMapping("/followStudent")
   public ModelAndView followStudent(@RequestParam("email") String email, Model model) { 
	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	  Student tempStudent = operation.searchUserByEmail(email);
	  
	  currentStudent.followings.add(email);
	  tempStudent.followers.add(this.emailAddress);
	  
	  operation.updateUserWithFollowings(currentStudent.followings, currentStudent);
	  operation.updateUserWithFollowers(tempStudent, tempStudent.followers);
	  
	  Comparator<Story> comparator = new Comparator<Story>(){
		  
          public int compare(Story st1, Story st2) {
               if(st1.getPublishedOn().after(st2.getPublishedOn()))
            		   return -1;
               else if (st1.getPublishedOn().before(st2.getPublishedOn()))
            		   return 1;
               else
            	   return 0;
          }

      };
      
      List<Story> stories = new ArrayList<Story>();
      for(int i = 0; i < currentStudent.followings.size(); i++){
    	  List<Story> temp = operation.viewBlogs(currentStudent.followings.get(i));
    	  stories.addAll(stories.size(), temp);
      }
      Collections.sort(stories, comparator);
      
      model.addAttribute("firstName", currentStudent.firstName);
	  model.addAttribute("followers", currentStudent.followers);
	  model.addAttribute("followings", currentStudent.followings);
	  return new ModelAndView("login", "Stories", stories);
   }
   
   @RequestMapping("/unfollowStudent")
   public ModelAndView unfollowStudent(@RequestParam("email") String email, Model model) { 
	  Student currentStudent = operation.searchUserByEmail(this.emailAddress);
	  Student tempStudent = operation.searchUserByEmail(email);
	  
	  currentStudent.followings.remove(email);
	  tempStudent.followers.remove(this.emailAddress);
	  
	  operation.updateUserWithFollowings(currentStudent.followings, currentStudent);
	  operation.updateUserWithFollowers(tempStudent, tempStudent.followers);
	  
	  Comparator<Story> comparator = new Comparator<Story>(){
		  
          public int compare(Story st1, Story st2) {
               if(st1.getPublishedOn().after(st2.getPublishedOn()))
            		   return -1;
               else if (st1.getPublishedOn().before(st2.getPublishedOn()))
            		   return 1;
               else
            	   return 0;
          }

      };
      
      List<Story> stories = new ArrayList<Story>();
      for(int i = 0; i < currentStudent.followings.size(); i++){
    	  List<Story> temp = operation.viewBlogs(currentStudent.followings.get(i));
    	  stories.addAll(stories.size(), temp);
      }
      Collections.sort(stories, comparator);
      
      model.addAttribute("firstName", currentStudent.firstName);
	  model.addAttribute("followers", currentStudent.followers);
	  model.addAttribute("followings", currentStudent.followings);
	  return new ModelAndView("login", "Stories", stories);
   }
}