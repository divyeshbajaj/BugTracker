package com.project.bugtracker.BugTracker.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "project_sequence")
public class ProjectSequence {

    @Id
    private String id;
    private Integer seqNo;
}
