package com.project.bugtracker.BugTracker.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.bugtracker.BugTracker.DTO.Project;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Document(collection = "Users")
public class UserEntity {
    
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Integer id;
    @NonNull
    private String userName;
    private Project project;
    @NonNull
    private String role;
}
