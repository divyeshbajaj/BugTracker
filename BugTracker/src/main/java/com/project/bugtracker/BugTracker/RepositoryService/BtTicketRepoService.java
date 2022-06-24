package com.project.bugtracker.BugTracker.RepositoryService;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.Ticket;

public interface BtTicketRepoService {

    ResponseEntity<Ticket> createTicketServiceRepo (Ticket ticket);
    ResponseEntity<Ticket> searchTicketServiceRepo (Integer id);
    ResponseEntity<Ticket> updateTicketServiceRepo (Ticket ticket ,Integer id);
}
