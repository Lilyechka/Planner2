package com.liliia.DataTransferObjects;

public class DTOUser {
    private long id_user;
    private static String username;
    private String role;

    public DTOUser(long id, String name, String role) {
        this.id_user = id;
        this.username = name;
        this.role = role;
    }

    public long getId() {
        return id_user;
    }

    public static String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id_user = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

