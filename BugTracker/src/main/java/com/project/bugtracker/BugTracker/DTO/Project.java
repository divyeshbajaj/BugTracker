package com.project.bugtracker.BugTracker.DTO;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    

    @Id
    private Integer id;
    @NotNull
    private String projectName;
    @NotNull
    private String description;
}
