package com.project.bugtracker.BugTracker.DTO;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    
    @Id
    private Integer id;
    @NonNull
    private String name;
}
