package com.coursemanagement.dto.responseDTOs;

import com.coursemanagement.model.enums.Role;
import java.util.UUID;

public class LoginResponse {
    private UUID id;
    private String fullName;
    private String email;
    private Role role;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(UUID id, String fullName, String email, Role role, String message) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}