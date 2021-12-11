package com.silver.ws.identityservice.application.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
public @Data class UserEntity implements Serializable {
    private static final long serialVersionUID = -456454654654L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String FirstName;

    @Column(nullable = false, length = 50)
    private String LastName;

    @Column(nullable = false, length = 120, unique = true)
    private String Email;

    @Column(nullable = false, unique = true)
    private String UserId;

    @Column(nullable = false)
    private String EncryptedPassword;
}
