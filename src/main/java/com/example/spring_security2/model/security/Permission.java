package com.example.spring_security2.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Permission {
    @Id
    @GeneratedValue
    private Integer id;
    private String permissionName;

    @ManyToMany
    private Set<Role> role;
}
