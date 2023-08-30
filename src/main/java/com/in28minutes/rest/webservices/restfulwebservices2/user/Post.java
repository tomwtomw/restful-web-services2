package com.in28minutes.rest.webservices.restfulwebservices2.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;
}
