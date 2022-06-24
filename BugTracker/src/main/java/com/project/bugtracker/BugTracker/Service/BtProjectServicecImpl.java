package com.project.bugtracker.BugTracker.Service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.bugtracker.BugTracker.DTO.Project;
import com.project.bugtracker.BugTracker.RepositoryService.BtRepoProjectService;

@Service
public class BtProjectServicecImpl  implements BtProjectService{

    @Autowired
    BtRepoProjectService btRepoProjectService;

    @Override
    public ResponseEntity<Project> createProjectService(Project project) {
        // TODO Auto-generated method stub

        return btRepoProjectService.createProjectServiceRepo(project);
    }

    @Override
    public ResponseEntity<Project> searchProjectService(Integer id) {
        // TODO Auto-generated method stub
        return btRepoProjectService.searchProjectServiceRepo(id);
    }

    @Override
    public ResponseEntity<Project> updateProjectService(Project project, Integer id) {
        // TODO Auto-generated method stub
        return btRepoProjectService.updateProjectServiceRepo(project, id);
    }

    @Override
    public ResponseEntity<Project> deleteProjectService(Integer id) {
        // TODO Auto-generated method stub
        return btRepoProjectService.deleteProjectServiceRepo(id);
    }
    
}
