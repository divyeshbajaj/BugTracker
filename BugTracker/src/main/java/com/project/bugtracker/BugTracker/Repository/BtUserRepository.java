package com.project.bugtracker.BugTracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.bugtracker.BugTracker.Entities.UserEntity;

public interface BtUserRepository extends MongoRepository<UserEntity , Integer>{
    
}
