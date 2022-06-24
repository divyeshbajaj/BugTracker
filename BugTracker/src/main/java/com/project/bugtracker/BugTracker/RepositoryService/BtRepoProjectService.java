package com.project.bugtracker.BugTracker.RepositoryService;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.Project;

public interface BtRepoProjectService {

    ResponseEntity<Project> createProjectServiceRepo (Project project);
    ResponseEntity<Project> searchProjectServiceRepo (Integer id);
    ResponseEntity<Project> updateProjectServiceRepo (Project project ,Integer id);
    ResponseEntity<Project> deleteProjectServiceRepo (Integer id);
}
