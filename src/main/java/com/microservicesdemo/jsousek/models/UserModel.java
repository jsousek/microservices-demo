package com.microservicesdemo.jsousek.models;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    @Size(min = 4, max = 20, message = "username must be in between 4 and 20 characters long")
    public String username;
    @NotNull
    @Size(min = 6, max = 36, message ="password must be in between 6 and 36 characters")
    @Column(name = "hashed_password")
    public String hashedPassword;
    @Column(name ="is_logged")
    boolean isLogged;

}
