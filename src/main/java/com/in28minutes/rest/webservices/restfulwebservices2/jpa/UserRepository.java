package com.in28minutes.rest.webservices.restfulwebservices2.jpa;

import com.in28minutes.rest.webservices.restfulwebservices2.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
