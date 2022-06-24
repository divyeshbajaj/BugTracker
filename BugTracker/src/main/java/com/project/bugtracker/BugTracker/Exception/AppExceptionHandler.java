package com.project.bugtracker.BugTracker.Exception;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    

    @ExceptionHandler(MappingException.class )
    public ResponseEntity<String> objectNotFoundException(MappingException ex , WebRequest wb){
        
        String errMsg = ex.getLocalizedMessage();
        return new ResponseEntity<String>("Request Body cannot be null", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> jsonException (HttpMessageNotReadableException jx){

        Map<String, String> errorMap = new HashMap<>();
        return new ResponseEntity<String>("Request body cannot be null", HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> nullUserFields (ObjectNotFoundException ex){
        String erroMsg = ex.getLocalizedMessage();
        return new ResponseEntity<String>(erroMsg, HttpStatus.BAD_REQUEST);
    }
}
