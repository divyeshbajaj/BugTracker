package com.project.bugtracker.BugTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.bugtracker.BugTracker.DTO.ResponseDto;
import com.project.bugtracker.BugTracker.DTO.User;
import com.project.bugtracker.BugTracker.RepositoryService.BtRepoUserService;

@Service
public class BtUserServiceImpl implements BtUserService{

    @Autowired
    BtRepoUserService btRepoUserService;

    @Override
    public ResponseEntity<ResponseDto> createUser(User user) {
        // TODO Auto-generated method stub
        if (!user.equals(null)){
            btRepoUserService.createUserRepoMethod(user);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(User user , Integer id) {
        // TODO Auto-generated method stub

            return btRepoUserService.updateUserRepoMethod(user, id);
        
    }

    @Override
    public ResponseDto deleteUser(Integer id) {
        // TODO Auto-generated method stub

        return btRepoUserService.deleteUserRepoMethod(id);
    }

    @Override
    public User searchUser(Integer id) {
        // TODO Auto-generated method stub
        
        return btRepoUserService.searchUser(id);
    }
    
}
