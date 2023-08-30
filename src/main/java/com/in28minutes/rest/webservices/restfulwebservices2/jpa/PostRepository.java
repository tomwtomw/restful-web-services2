package com.in28minutes.rest.webservices.restfulwebservices2.jpa;

import com.in28minutes.rest.webservices.restfulwebservices2.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
