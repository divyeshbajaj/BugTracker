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
import com.project.bugtracker.BugTracker.DTO.Ticket;
import com.project.bugtracker.BugTracker.DTO.User;
import com.project.bugtracker.BugTracker.Entities.TicketEntity;
import com.project.bugtracker.BugTracker.Exception.ObjectNotFoundException;
import com.project.bugtracker.BugTracker.Repository.BtTicketRepository;
import com.project.bugtracker.BugTracker.Service.BtProjectService;
import com.project.bugtracker.BugTracker.Service.BtUserService;
import com.project.bugtracker.BugTracker.Service.SequenceGenerator;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BtTicketRepoServiceImpl  implements BtTicketRepoService{

    @Autowired
    BtProjectService btProjectService;
    @Autowired
    BtUserService btUserService;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    BtTicketRepository btTicketRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<Ticket> createTicketServiceRepo(Ticket ticket) {
        // TODO Auto-generated method stub
        if (ticket.getDescription().isEmpty() || ticket.getDeveloper()== null
        || ticket.getProjectId() == null || ticket.getSubmittedBy().isEmpty()){
            throw new ObjectNotFoundException("Ticket attributes cannot be null");
           
        }else{ 

                Integer projectId = ticket.getProjectId();
                User ticketUser = ticket.getDeveloper();

                log.info("Project object "+ projectId);
                ResponseEntity<Project> result = btProjectService.searchProjectService(projectId);
                User user = btUserService.searchUser(ticketUser.getId());

                 log.info("user object "+ user);
                 if (result == null && user == null) {
                    throw new ObjectNotFoundException("Project or User does not exists for the ticket, input a valid projectId, or  user");
              
                }
            Integer id = sequenceGenerator.ticketSequenceGenerator(TicketEntity.SEQUENCE_NAME);
            ticket.setId(id); 
            TicketEntity tEntity = modelMapper.map(ticket, TicketEntity.class);
            btTicketRepository.save(tEntity);
            
           // return new ResponseEntity<>(HttpStatus.OK).ok(ticket);
           return ResponseEntity.ok(ticket);
        }
    }

    @Override
    public ResponseEntity<Ticket> searchTicketServiceRepo(Integer id) {
        // TODO Auto-generated method stub
        Optional<TicketEntity> tEntity = btTicketRepository.findById(id);
        if (tEntity.isPresent()){
            log.info("found user" + tEntity);
           
            Ticket ticket = new ObjectMapper().convertValue(tEntity.get(), Ticket.class);
            log.info("before user" + ticket);
            return  ResponseEntity.ok(ticket);
        }else {
            throw new ObjectNotFoundException("Invalid ticket, input correct id");
        }
    }

    @Override
    public ResponseEntity<Ticket> updateTicketServiceRepo(Ticket ticket, Integer id) {
        // TODO Auto-generated method stub

        Optional<TicketEntity> ticketLocal= btTicketRepository.findById(id);

        if (ticketLocal.isPresent()){
            
            ticketLocal.get().setDescription(ticket.getDescription());
            ticketLocal.get().setProjectId(ticket.getProjectId());
            ticketLocal.get().setDeveloper(ticket.getDeveloper());
            ticketLocal.get().setSubmittedBy(ticket.getSubmittedBy());

            btTicketRepository.save(ticketLocal.get());
            return  ResponseEntity.ok(modelMapper.map(ticketLocal.get()
            , Ticket.class));
        }
        else {
            throw new ObjectNotFoundException("Invalid ticket id for update");
        }
    }

  
}
