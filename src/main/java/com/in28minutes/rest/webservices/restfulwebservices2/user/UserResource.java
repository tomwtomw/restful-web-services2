package com.in28minutes.rest.webservices.restfulwebservices2.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllusers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userid}")
    public EntityModel<User> retrieveUserById(@PathVariable Integer userid) {
        User user = userDaoService.findOne(userid);
        if (user != null) {
            EntityModel<User> entityModel = EntityModel.of(user);
            WebMvcLinkBuilder link = linkTo(
                    WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllusers()
            );
            entityModel.add(link.withRel("all-users"));
            return entityModel;
        } else {
            throw new UserNotFoundException("User " + userid + " not found");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userid}")
    public void deleteUserById(@PathVariable Integer userid) {
        userDaoService.deleteById(userid);
    }
}
