package com.project.bugtracker.BugTracker.RepositoryService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.ModelMethodProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bugtracker.BugTracker.DTO.Project;
import com.project.bugtracker.BugTracker.Entities.ProjectEntity;
import com.project.bugtracker.BugTracker.Exception.ObjectNotFoundException;
import com.project.bugtracker.BugTracker.Repository.BtProjectRepository;
import com.project.bugtracker.BugTracker.Service.SequenceGenerator;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BtRepoProjectServiceImpl implements BtRepoProjectService {

    @Autowired 
    SequenceGenerator sequenceGenerator;
    @Autowired
    BtProjectRepository btProjectRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<Project> createProjectServiceRepo(Project project) {
        // TODO Auto-generated method stub

        if (project.getProjectName()!=null && project.getDescription() != null){
            Integer projectId = sequenceGenerator.projectSequenceGenerator(ProjectEntity.SEQUENCE_NAME);
            project.setId(projectId);
            btProjectRepository.save(modelMapper.map(project, ProjectEntity.class));
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }else {
            throw new ObjectNotFoundException("Project object consists of null values");
        }  
    }

    @Override
    public ResponseEntity<Project> searchProjectServiceRepo(Integer id) {
        // TODO Auto-generated method stub
        Optional<ProjectEntity> pEntity = btProjectRepository.findById(id);
        if (pEntity.isPresent()){
            log.info("found project" + pEntity);
           // User user = modelMapper.map(uEntity, User.class);
            Project project = new ObjectMapper().convertValue(pEntity.get(), Project.class);
            log.info("before user" + project);
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }else {
            throw new ObjectNotFoundException("Invalid project, input correct id");
        }
    }

    @Override
    public ResponseEntity<Project> updateProjectServiceRepo(Project project, Integer id) {
        // TODO Auto-generated method stub
        Optional<ProjectEntity> projectLocal= btProjectRepository.findById(id);

        if (projectLocal.isPresent()){
            
            projectLocal.get().setProjectName(project.getProjectName());
            projectLocal.get().setDescription(project.getDescription());


            btProjectRepository.save(projectLocal.get());

            return new ResponseEntity<>(HttpStatus.OK).ok(modelMapper.map(projectLocal.get(), Project.class));
        }
        else {
            throw new ObjectNotFoundException("Invalid project id for update");
        }
    }

    @Override
    public ResponseEntity<Project> deleteProjectServiceRepo(Integer id) {
        // TODO Auto-generated method stub
        Optional<ProjectEntity> pEntity = btProjectRepository.findById(id);
        if (pEntity.isPresent()){
            btProjectRepository.delete(pEntity.get());
            return new ResponseEntity<Project>(modelMapper.map(pEntity.get(), Project.class), HttpStatus.OK) ;
        }else{
            throw new ObjectNotFoundException("Invalid project id for delete");
        }
    }
    
}
