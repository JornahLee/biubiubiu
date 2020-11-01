package com.jornah.biubiubiu.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private List<Role> roles;
}
