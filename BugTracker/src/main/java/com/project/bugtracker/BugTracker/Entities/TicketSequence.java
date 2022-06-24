package com.project.bugtracker.BugTracker.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "ticket_sequence")
public class TicketSequence {
    
    @Id
    private String id;
    private Integer seqNo;
}
