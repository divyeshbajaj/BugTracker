package com.project.bugtracker.BugTracker.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "user_sequence")
public class userSequence {
    
    @Id
    private String id;
    private Integer seqNo; 
}
