package com.ericardo.toDo.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.ericardo.toDo.models.Task;
import com.ericardo.toDo.models.Item;

@Entity
public class User {

	/*************************************** ATTRIBUTES **************************************/
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=25, message="Please provide your first name.")
	private String firstName;
	
	@Size(min=1, max=25, message="Please provide your last name.")
	private String lastName;
	
	@Email(message="Invalid E-mail format. Ex: example@example.com")
	private String email;
	
	@Size(min=8, max=25, message="Please provide a password longer than eight characters")
	private String password;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	 	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	/************************************* RELATIONSHIPS *************************************/
	 	
	/*************************************** with task ***************************************/
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
 	private List<Task> tasks;
 	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}	
	
	/*************************************** with item ***************************************/
	 	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
 	private List<Item> items;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	/********************************* PERSIST AND UPDATE  **********************************/
	 	
	@PrePersist
	public void onCreate() {
	 	this.createdAt = new Date();
	}
	 	
	@PreUpdate
	public void onUpdate() {
	 	this.updatedAt = new Date();
	}
	/******************************** SETTERS AND GETTERS  **********************************/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/********************************** EMPTY CONSTRUCTOR  **********************************/
	 	
	public User() {
	 	this.createdAt = new Date();
	 	this.updatedAt = new Date();
	}

}
