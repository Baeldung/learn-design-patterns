package com.baeldung.ldp.proxy;

public class UserContext {

    private final UserRole role;

    public UserContext(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }
}
