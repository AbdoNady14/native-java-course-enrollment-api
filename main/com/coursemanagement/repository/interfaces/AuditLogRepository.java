package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.AuditLog;
import java.util.List;
import java.util.UUID;

public interface AuditLogRepository {
    void save(AuditLog auditLog);

    AuditLog findById(UUID id);

    List<AuditLog> findAll();

    List<AuditLog> findByEntityType(String entityType);

}
