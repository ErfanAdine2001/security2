package com.example.spring_security2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String password;

    @Column(unique = true)
    private String username;

    @Builder.Default
    private Boolean isEnabled = true;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Role> roles = new HashSet<>();


    public  Set<SimpleGrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getAuthority().stream())
                .collect(Collectors.toSet());
    }

}
