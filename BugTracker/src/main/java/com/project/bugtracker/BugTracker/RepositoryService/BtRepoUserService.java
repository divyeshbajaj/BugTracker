package com.project.bugtracker.BugTracker.RepositoryService;

import com.project.bugtracker.BugTracker.DTO.User;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.ResponseDto;

public interface BtRepoUserService {
    

    ResponseEntity<ResponseDto>createUserRepoMethod (User user);
    ResponseEntity<User>updateUserRepoMethod (User user , Integer id );
    ResponseDto deleteUserRepoMethod (Integer id);
    User searchUser(Integer id);
}

