package com.project.bugtracker.BugTracker.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    
    @Id
    private Integer id;
    @NotNull(message = "Username cannot be null")
    private String userName;
    private Project project;
    @NotNull(message = "Role cannot be null")
    private String role;
}
