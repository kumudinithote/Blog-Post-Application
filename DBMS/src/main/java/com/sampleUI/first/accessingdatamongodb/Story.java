package com.sampleUI.first.accessingdatamongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Story {
	@Id
	public String id;
    
	public String blogTitle;
	public String email;
	public String genre;
	public String story;
	public Date publishedOn;
	public List<String> upvotes;
	
	public Story() {}

    public Story(String blogTitle, String email, String genre, String story) {
    	this.blogTitle = blogTitle;
        this.email = email;
        this.genre = genre;
        this.story = story;
        this.publishedOn = new Date();
        this.upvotes = new ArrayList<String>();
    }
    
    public Story(String id, String blogTitle, String email, String genre, String story, List<String> upvotes) {
    	this.id = id;
    	this.blogTitle = blogTitle;
        this.email = email;
        this.genre = genre;
        this.story = story;
        this.upvotes = upvotes;
        this.publishedOn = new Date();
    }
    
    public Story(Story story) {
    	this.id = story.id;
    	this.blogTitle = story.blogTitle;
        this.email = story.email;
        this.genre = story.genre;
        this.story = story.story;
        this.upvotes = story.upvotes;
        this.publishedOn = story.publishedOn;
    }
    
    public List<String> getUpvotes() {
        return upvotes;
    }
    
    public String getId() {
        return id;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getBlogTitle() {
        return blogTitle;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getStory() {
        return story;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Story[id=%s, blogTitle = '%s', email='%s', genre='%s', story='%s', publishedOn=%s]",
                id, blogTitle, email, genre, story, publishedOn);
    }
}
