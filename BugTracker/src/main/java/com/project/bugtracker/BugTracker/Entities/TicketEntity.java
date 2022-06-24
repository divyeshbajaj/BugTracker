package com.project.bugtracker.BugTracker.Entities;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.bugtracker.BugTracker.DTO.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Document(collection = "tickets")
public class TicketEntity {
    
    @Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";
    @Id
    private Integer id;
    @NonNull
    private String description;
    private User developer;
    @NonNull
    private Integer projectId ;
    @NonNull
    private String submittedBy;
    private String comments;
    @CreatedDate
    private Date creationDate;
}
