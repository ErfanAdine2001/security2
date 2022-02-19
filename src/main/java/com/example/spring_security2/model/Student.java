package com.example.spring_security2.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
//    private String username;
//    private String password;
//    private String  email;
}
