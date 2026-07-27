package com.coursemanagement.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditLog {
    private UUID id;
    private String action;
    private String entityType;
    private Long entityId;
    private String description;
    private LocalDateTime createdAt;

    public AuditLog() {
    }

    public AuditLog(String action, String entityType, Long entityId, String description) {
        this.id = UUID.randomUUID();
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AuditLog{" +"id=" + id +", action='" + action + "', entityType='" + entityType + "', entityId=" + entityId +", description='" + description + "', createdAt=" + createdAt +"}";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof AuditLog auditLog)) return false;
        return this.id.equals(auditLog.getId())&& this.action.equals(auditLog.getAction())&& this.entityType.equals(auditLog.getEntityType())&& this.entityId.equals(auditLog.getEntityId())&& this.description.equals(auditLog.getDescription());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
