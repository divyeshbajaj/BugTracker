package com.project.bugtracker.BugTracker.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Document(collection = "roles")
public class RoleEntity {
    
    @Id
    private Integer id;
    @NonNull
    private String name;
}
