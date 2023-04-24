package com.gl.ticketTracker.TicketTraker.controller;

 


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.ticketTracker.TicketTraker.service.TicketTrackerService;
import com.gl.ticketTracker.TicketTraker.model.TicketTracker;

@Controller
public class TickrtTtackerController {
	
	private TicketTrackerService tickettrackerService;

	public TickrtTtackerController(TicketTrackerService tickettrackerService) {
		super();
		this.tickettrackerService = tickettrackerService;
	}
	
	// handler Method
	@GetMapping("/tickets")
	public String listtickets(Model model) {
		model.addAttribute("tickets", tickettrackerService.getAllTickets());
		return "tickets";
	}
	
	@GetMapping("/tickets/new")
	public String createticketform(Model model) {
		
		// create ticket object to hold ticket form data

		TicketTracker  ticket = new TicketTracker();
		model.addAttribute("ticket", ticket);
		
		return "create_ticket";
	
	}
	
	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") TicketTracker ticket ) {
		
		tickettrackerService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	@GetMapping("/tickets/edit/{id}")
	//@RequestMapping(value = "/tickets/edit/{id}", method = RequestMethod.GET)
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", tickettrackerService.getTicketByID(id));
		return "edit_ticket";
	}
	
	@GetMapping("/tickets/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("ticket") TicketTracker ticket, Model model) {

		// get employee from database by id

		TicketTracker existingTicket = tickettrackerService.getTicketByID(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setCreatedDate(ticket.getCreatedDate());

		// save updated employee object
		tickettrackerService.updateTicket(existingTicket);

		return "redirect:/tickets";
	}
	
	
	@GetMapping("/tickets/delete/{id}")
	public String deleteemployee(@PathVariable Long id) {
		tickettrackerService.deleteEmployeeById(id);
		return "redirect:/tickets";
	}
	
	// fetch by title
	@RequestMapping("/tickets/search/")
		public String ticketSearch(String title, Model model) {
			System.out.println("inside");
			System.out.println(title);
					model.addAttribute("tickets", tickettrackerService.searchByTitle(title));
		return "tickets";
		}

	
	

}
