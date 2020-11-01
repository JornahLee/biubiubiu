package com.jornah.biubiubiu.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role {
    private Long id;
    private String roleName;
    private String roleNameZH;

    public static Role of(String roleName){
        Role role = new Role();
        role.setId(0L);
        role.setRoleName(roleName);
        role.setRoleNameZH(roleName+"_zh");
        return role;
    }

}
