package com.nicof.shortit.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Document
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String resetPasswordToken;
    private LocalDateTime resetPasswordTokenExpiration;
    private boolean confirmed;
    private String accountConfirmationToken;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

}
