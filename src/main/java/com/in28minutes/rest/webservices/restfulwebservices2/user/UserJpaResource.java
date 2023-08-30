package com.in28minutes.rest.webservices.restfulwebservices2.user;

import com.in28minutes.rest.webservices.restfulwebservices2.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserJpaResource {
    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private UserRepository repository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllusers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{userid}")
    public EntityModel<User> retrieveUserById(@PathVariable Integer userid) {
        Optional<User> user = repository.findById(userid);
        if (!user.isEmpty()) {
            EntityModel<User> entityModel = EntityModel.of(user.get());
            WebMvcLinkBuilder link = linkTo(
                    WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllusers()
            );
            entityModel.add(link.withRel("all-users"));
            return entityModel;
        } else {
            throw new UserNotFoundException("User " + userid + " not found");
        }
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{userid}")
    public void deleteUserById(@PathVariable Integer userid) {
        repository.deleteById(userid);
    }
}
