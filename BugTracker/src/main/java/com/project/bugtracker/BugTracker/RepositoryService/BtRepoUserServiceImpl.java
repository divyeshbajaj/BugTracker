package com.project.bugtracker.BugTracker.RepositoryService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bugtracker.BugTracker.DTO.Project;
import com.project.bugtracker.BugTracker.DTO.ResponseDto;
import com.project.bugtracker.BugTracker.DTO.User;
import com.project.bugtracker.BugTracker.Entities.ProjectEntity;
import com.project.bugtracker.BugTracker.Entities.UserEntity;
import com.project.bugtracker.BugTracker.Exception.ObjectNotFoundException;
import com.project.bugtracker.BugTracker.Repository.BtProjectRepository;
import com.project.bugtracker.BugTracker.Repository.BtUserRepository;
import com.project.bugtracker.BugTracker.Service.SequenceGenerator;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BtRepoUserServiceImpl  implements BtRepoUserService{

    @Autowired
    BtUserRepository btUserRepository;

    @Autowired
    BtProjectRepository btProjectRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Override
    public ResponseEntity<ResponseDto> createUserRepoMethod(User user) {
        // TODO Auto-generated method stub
        // result = false;
        if (user.getRole().isEmpty() || user.getUserName().isEmpty()){
            throw new ObjectNotFoundException("User attributes cannot be null");
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{ 
            
            if (user.getProject() != null){
                Project project = user.getProject();
                log.info("Project object "+ project);
                 ProjectEntity result = btProjectRepository.findExistingProject(project.getProjectName(), project.getDescription());
                 log.info("result object "+ result);
                 if (result == null) {
                    throw new ObjectNotFoundException("Project does not exists, input a valid project");
                }
            }
            Integer id = sequenceGenerator.usergenerateSequence(UserEntity.SEQUENCE_NAME);
            user.setId(id); 
            UserEntity userEntity = modelMapper.map(user, UserEntity.class);
            btUserRepository.save(userEntity);
            
            return new ResponseEntity<>(HttpStatus.OK).ok(new ModelMapper().map(user, ResponseDto.class));
        }
        
    }

    @Override
    public ResponseEntity<User> updateUserRepoMethod(User user , Integer id) {
        // TODO Auto-generated method stub

        Optional<UserEntity> userLocal= btUserRepository.findById(id);

        if (userLocal.isPresent()){
            
            userLocal.get().setUserName(user.getUserName());
            userLocal.get().setRole(user.getRole());
            userLocal.get().setProject(user.getProject());

            btUserRepository.save(userLocal.get());

            return new ResponseEntity<>(HttpStatus.OK).ok(modelMapper.map(userLocal.get(), User.class));
        }
        else {
            throw new ObjectNotFoundException("Invalid user id for update");
        }
        
    }

    @Override
    public ResponseDto deleteUserRepoMethod(Integer id) {
        // TODO Auto-generated method stub
        Optional<UserEntity> uEntity = btUserRepository.findById(id);
        if (uEntity.isPresent()){
            btUserRepository.delete(uEntity.get());
            return modelMapper.map(uEntity.get(), ResponseDto.class);
        }else{
            throw new ObjectNotFoundException("Invalid user id for delete");
        }
        
    }

    @Override
    public User searchUser(Integer id) {
        // TODO Auto-generated method stub
        Optional<UserEntity> uEntity = btUserRepository.findById(id);
        if (uEntity.isPresent()){
            log.info("found user" + uEntity);
           // User user = modelMapper.map(uEntity, User.class);
            User user = new ObjectMapper().convertValue(uEntity.get(), User.class);
            log.info("before user" + user);
            return user;
        }else {
            throw new ObjectNotFoundException("Invalid user input correct id");
        }
    }
    
}
