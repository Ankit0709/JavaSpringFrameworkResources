package com.springsecurity.learning.SpringSecurityLearning.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USERNAME",nullable = false,unique = true)
    private String username;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

}
