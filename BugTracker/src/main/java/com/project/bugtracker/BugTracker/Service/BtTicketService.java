package com.project.bugtracker.BugTracker.Service;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.Ticket;

public interface BtTicketService {
    
    ResponseEntity<Ticket> createTicketService (Ticket ticket);
    ResponseEntity<Ticket> searchTicketService (Integer id);
    ResponseEntity<Ticket> updateTicketService (Ticket ticket ,Integer id);
}
