package com.coursemanagement.model;
import java.time.LocalDateTime;
import java.util.UUID;

import com.coursemanagement.model.enums.Role;

public class Student {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private Boolean active;
    private LocalDateTime createdAt;

    public Student() {
    }

    public Student(String fullName, String email, String password, Role role, Boolean active) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.createdAt = LocalDateTime.now();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Student{id=" + id +", fullName='" + fullName + "', email='" + email + "', role=" + role +", active=" + active +", createdAt=" + createdAt +"}";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Student student)) return false;
        return this.id.equals(student.getId())&& this.email.equals(student.getEmail())&& this.fullName.equals(student.getFullName())&& this.role.equals(student.getRole())&& this.active.equals(student.getActive());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
