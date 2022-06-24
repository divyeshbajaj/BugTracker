package com.project.bugtracker.BugTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.bugtracker.BugTracker.DTO.Ticket;
import com.project.bugtracker.BugTracker.RepositoryService.BtTicketRepoService;

@Service
public class BtTicketServiceImpl implements BtTicketService {

    @Autowired
    BtTicketRepoService btTicketRepoService;

    @Override
    public ResponseEntity<Ticket> createTicketService(Ticket ticket) {
        // TODO Auto-generated method stub
        return btTicketRepoService.createTicketServiceRepo(ticket);
    }

    @Override
    public ResponseEntity<Ticket> searchTicketService(Integer id) {
        // TODO Auto-generated method stub
        return btTicketRepoService.searchTicketServiceRepo(id);
    }

    @Override
    public ResponseEntity<Ticket> updateTicketService(Ticket ticket, Integer id) {
        // TODO Auto-generated method stub
        return btTicketRepoService.updateTicketServiceRepo(ticket, id);
    }

    }
