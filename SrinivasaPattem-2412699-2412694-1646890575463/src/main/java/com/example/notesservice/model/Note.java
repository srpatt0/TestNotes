package com.example.notesservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

public class Note {	
	
    private Integer id;
    
    @NotBlank(message = "Title is mandatory!")	
	@Size(min=5, max=20, message = "At least 5 characters are required!")
	private String title;
    
    @NotBlank(message = "Autohr is mandatory!")	
	@Size(min=5, max=20, message = "At least 5 characters are required!")
	private String author;
    
    @NotBlank(message = "Description is mandatory!")	
	@Size(min=5, max=200, message = "At least 5 characters are required!")
	private String description;
    
    @NotBlank(message = "Status is mandatory!")	
	@Value("${some.key:compelted,pending}")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
