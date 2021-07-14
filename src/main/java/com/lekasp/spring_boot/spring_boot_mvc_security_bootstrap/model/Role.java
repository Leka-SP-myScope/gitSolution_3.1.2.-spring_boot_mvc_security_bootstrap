package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    //@ManyToOne(fetch = FetchType.LAZY)
//    //@JoinColumn(name = "users_id")
//    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(Long id) {
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }

//    public Set<User> getUser() {
//        return users;
//    }
//
//    public void setUser(Set<User> users) {
//        this.users = users;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role1 = (Role) o;
//        return id.equals(role1.id) &&
//                role.equals(role1.role);
//    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result * ((id == null) ? 0 : id.hashCode());
        return result;
    }
}