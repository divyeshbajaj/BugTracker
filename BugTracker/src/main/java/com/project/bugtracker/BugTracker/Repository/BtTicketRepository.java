package com.project.bugtracker.BugTracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.bugtracker.BugTracker.Entities.TicketEntity;

public interface BtTicketRepository extends MongoRepository <TicketEntity , Integer> {
    
}
