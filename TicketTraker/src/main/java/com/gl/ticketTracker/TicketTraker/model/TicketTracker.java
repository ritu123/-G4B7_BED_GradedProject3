package com.gl.ticketTracker.TicketTraker.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickettracker")
public class TicketTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date", nullable = false)
	private String createdDate;
	
	public TicketTracker() {
		
	}
	
	public TicketTracker(Long id, String title, String description, String createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	 

}
