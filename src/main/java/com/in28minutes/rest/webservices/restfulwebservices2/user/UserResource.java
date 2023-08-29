package com.in28minutes.rest.webservices.restfulwebservices2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllusers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userid}")
    public User retrieveUserById(@PathVariable Integer userid) {
        return userDaoService.findOne(userid);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userDaoService.save(user);
    }
}
