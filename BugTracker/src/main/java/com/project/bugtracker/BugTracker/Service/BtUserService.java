package com.project.bugtracker.BugTracker.Service;

import org.springframework.http.ResponseEntity;

import com.project.bugtracker.BugTracker.DTO.ResponseDto;
import com.project.bugtracker.BugTracker.DTO.User;

public interface BtUserService {
    
    ResponseEntity<ResponseDto>createUser (User user);
    ResponseEntity<User>updateUser (User user, Integer id);
    ResponseDto deleteUser (Integer id);
    User searchUser (Integer id);
}
