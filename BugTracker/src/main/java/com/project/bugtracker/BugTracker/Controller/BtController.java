package com.project.bugtracker.BugTracker.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bugtracker.BugTracker.DTO.Project;
import com.project.bugtracker.BugTracker.DTO.ResponseDto;
import com.project.bugtracker.BugTracker.DTO.Ticket;
import com.project.bugtracker.BugTracker.DTO.User;
import com.project.bugtracker.BugTracker.Service.BtProjectService;
import com.project.bugtracker.BugTracker.Service.BtTicketService;
import com.project.bugtracker.BugTracker.Service.BtUserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
//@RequestMapping("/bugTracker")
public class BtController {
    
    @Autowired
    BtUserService btUserService;

    @Autowired
    BtProjectService btProjectService;

    @Autowired
    BtTicketService btTicketService;

    @PostMapping("/createuser")
    public ResponseEntity<ResponseDto> createUser( @RequestBody(required = true) @Valid User user){
        
        return btUserService.createUser(user);
    }

    @GetMapping("/getuser/{id}")
    public User getUserById(@PathVariable("id") Integer id){

        return btUserService.searchUser(id);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Integer id, @RequestBody User user ){

        return btUserService.updateUser(user , id);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseDto deleteUserById(@PathVariable("id") Integer id ){

        return btUserService.deleteUser(id);
    }

    @PostMapping("/createproject")
    public ResponseEntity<Project> createProject (@RequestBody @Valid Project project){

        log.info("Printing project"+project);
         
        return btProjectService.createProjectService(project);
    } 

    @GetMapping("/searchproject/{id}")
    public ResponseEntity<Project> searchProject (@PathVariable("id")Integer id){
        return btProjectService.searchProjectService(id);
    } 
    @PutMapping("/updateproject/{id}")
    public ResponseEntity<Project> updateProject (@PathVariable("id") Integer id,@RequestBody @Valid Project project ){
        return btProjectService.updateProjectService(project , id);
    } 
    @DeleteMapping("/deleteproject/{id}")
    public ResponseEntity<Project> deleteProject (@PathVariable("id")Integer id){
        return btProjectService.deleteProjectService(id);
    } 

    @PostMapping("/createticket")
    public ResponseEntity<Ticket> createticket (@RequestBody @Valid Ticket ticket){

        log.info("Printing ticket"+ticket);
         
        return btTicketService.createTicketService(ticket);
    } 

    @GetMapping("/searchticket/{id}")
    public ResponseEntity<Ticket> searchTicket (@PathVariable("id")Integer id){
        return btTicketService.searchTicketService(id);
    } 
    @PutMapping("/updateticket/{id}")
    public ResponseEntity<Ticket> updateTicket (@PathVariable("id") Integer id,@RequestBody @Valid Ticket ticket ){
        return btTicketService.updateTicketService(ticket, id);
    } 

}
