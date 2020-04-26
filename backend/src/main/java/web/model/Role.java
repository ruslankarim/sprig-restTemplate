package web.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role {
    USER, ADMIN;

    @Override
    public String toString() {
        return name();
    }
}