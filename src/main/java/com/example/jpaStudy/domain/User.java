package com.example.jpaStudy.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;

    private String name;

    @Embedded
    private Address address;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    protected User() {
    }

    public User(String email, String name, Address address, LocalDateTime createDate) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Address getAddress(){
        return address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
