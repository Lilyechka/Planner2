package com.liliia.DataTransferObjects;

public class DTOUser {
    private long id_user;
    private String username;
    private String role;

    public DTOUser(long id, String name, String role) {
        this.id_user = id;
        this.username = name;
        this.role = role;
    }

    public long getId() {
        return id_user;
    }

    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id_user = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

