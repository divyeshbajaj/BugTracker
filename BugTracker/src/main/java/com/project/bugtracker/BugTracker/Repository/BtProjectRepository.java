package com.project.bugtracker.BugTracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.bugtracker.BugTracker.Entities.ProjectEntity;

public interface BtProjectRepository extends MongoRepository<ProjectEntity , Integer>{
    
    @Query("{'projectName' : ?0 , 'description' : ?1}")
    ProjectEntity findExistingProject (String name , String description);

}
