package com.in28minutes.rest.webservices.restfulwebservices2.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    @Size(min = 2, message = "name should have at least 2 characters")
    private String name;
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
}
