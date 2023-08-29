package com.in28minutes.rest.webservices.restfulwebservices2.helloworld;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HelloWorldBean {
    private final String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }
}
