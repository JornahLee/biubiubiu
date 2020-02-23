package com.jornah.biubiubiu.pojo;

public class Role {
    private Integer rid;
    private String roleName;
    private String roleNameZH;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameZH() {
        return roleNameZH;
    }

    public void setRoleNameZH(String roleNameZH) {
        this.roleNameZH = roleNameZH;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", roleName='" + roleName + '\'' +
                ", roleNameZH='" + roleNameZH + '\'' +
                '}';
    }
}
