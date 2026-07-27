package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.AuditLog;
import java.util.List;
import java.util.UUID;

public interface AuditLogRepository {
    public void save(AuditLog auditLog);

    public AuditLog findById(UUID id);

    public List<AuditLog> findAll();

    public List<AuditLog> findByEntityType(String entityType);

}
