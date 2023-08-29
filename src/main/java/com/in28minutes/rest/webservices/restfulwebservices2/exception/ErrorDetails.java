package com.in28minutes.rest.webservices.restfulwebservices2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
