package com.jornah.biubiubiu.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class Resource {
    private Long id;
    private String url;
    private String resName;
    private List<Role> roles;
}
