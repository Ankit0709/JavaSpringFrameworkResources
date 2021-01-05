package com.springsecurity.learning.SpringSecurityLearning.auth;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTH_GROUP")
@Data
public class AuthGroup {

    @Id
    @Column(name = "AUTH_USER_GROUP_ID")
    private long AuthId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "AUTH_GROUP")
    private String authGroup;
}
