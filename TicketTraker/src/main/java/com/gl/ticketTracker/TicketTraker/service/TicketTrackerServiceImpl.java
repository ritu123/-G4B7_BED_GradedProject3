package com.gl.ticketTracker.TicketTraker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gl.ticketTracker.TicketTraker.model.TicketTracker;

import com.gl.ticketTracker.TicketTraker.dao.TickettrackerRepository;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {
    
	private TickettrackerRepository  tickettrackerRepository;
	
	
	public TicketTrackerServiceImpl(TickettrackerRepository tickettrackerRepository) {
	
	      this.tickettrackerRepository = tickettrackerRepository;
	}

	@Override
	public List<TicketTracker> getAllTickets() {
		 return tickettrackerRepository.findAll(); 
	}

	@Override
	public TicketTracker saveTicket(TicketTracker ticket) {
	    return tickettrackerRepository.save(ticket);
	}

	@Override
	public TicketTracker getTicketByID(Long id) {

		return tickettrackerRepository.findById(id).get();
	}

	@Override
	public TicketTracker updateTicket(TicketTracker ticket) {
		 return tickettrackerRepository.save(ticket);
	}

	@Override
	public void  deleteEmployeeById(Long id) {
		tickettrackerRepository.deleteById(id);
	}

	 
	
	public List<TicketTracker> searchByTitle(String title) {
		System.out.println(title);
		return tickettrackerRepository.findBytitle(title);
	}


}
