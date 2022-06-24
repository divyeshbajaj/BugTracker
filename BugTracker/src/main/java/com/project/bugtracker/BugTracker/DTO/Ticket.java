package com.project.bugtracker.BugTracker.DTO;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Ticket {
   
    @Id
    private Integer id;
    @NonNull
    private String description;
    @NotNull
    private  @Valid User developer;
    @NonNull
    private Integer projectId ;
    @NonNull
    private String submittedBy;
    private String comments;
    @CreatedDate
    private Date creationDate;

}
