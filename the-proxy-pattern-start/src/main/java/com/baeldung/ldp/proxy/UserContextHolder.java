package com.baeldung.ldp.proxy;

public class UserContextHolder {

    private static final ThreadLocal<UserRole> currentRole = new ThreadLocal<>();

    public static void setRole(UserRole role) {
        currentRole.set(role);
    }

    public static UserRole getRole() {
        return currentRole.get();
    }
}
