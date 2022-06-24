package com.project.bugtracker.BugTracker.Entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Document(collection = "projects")
public class ProjectEntity {
    
    @Transient
    public static final String SEQUENCE_NAME = "PROJECT_SEQUENCE";
    @Id
    private Integer id;
    @NonNull
    private String projectName;
    @NonNull
    private String description;

}
