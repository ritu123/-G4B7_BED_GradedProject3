package com.gl.ticketTracker.TicketTraker.service;

import java.util.List;

import com.gl.ticketTracker.TicketTraker.model.TicketTracker;

public interface TicketTrackerService {
	
	List<TicketTracker> getAllTickets();
	
	TicketTracker saveTicket(TicketTracker ticket);
	
	TicketTracker getTicketByID(Long id);
	
	TicketTracker updateTicket(TicketTracker ticket);
	
	
	void deleteEmployeeById(Long id);
	
	List<TicketTracker> searchByTitle(String title);
	
	
	
	
	
	

}
