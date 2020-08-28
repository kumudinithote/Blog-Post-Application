package com.sampleUI.first.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface StoryRepository extends MongoRepository<Story, String>{
	public Story findByBlogTitleAllIgnoreCase(String blogTitle);
	public List<Story> findByEmailOrderByPublishedOnDescAllIgnoreCase(String email);
	public void deleteById(String id);
	public Story findById(String id);
	public List<Story> findByGenreOrderByPublishedOnDescAllIgnoreCase(String genre);
	public List<Story> findByBlogTitleContainingOrderByPublishedOnDescAllIgnoreCase(String genre);
}
