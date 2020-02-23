package com.jornah.biubiubiu.pojo;

import java.util.List;

public class Resource {
    private int id;
    private String url;
    private String resName;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", resName='" + resName + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
