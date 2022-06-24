package com.project.bugtracker.BugTracker.Service;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.Project;

public interface BtProjectService {
    
    ResponseEntity<Project> createProjectService (Project project);
    ResponseEntity<Project> searchProjectService (Integer id);
    ResponseEntity<Project> updateProjectService (Project project ,Integer id);
    ResponseEntity<Project> deleteProjectService (Integer id);
}
