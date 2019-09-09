package ru.molcom.domain;

import javax.persistence.Table;

@Table(name = "userr")
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private boolean enabled = true;

    private PrimaryAccount primaryAccount;
}
