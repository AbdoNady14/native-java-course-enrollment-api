package com.coursemanagement.repository;

import com.coursemanagement.model.AuditLog;
import com.coursemanagement.repository.interfaces.AuditLogRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryAuditLogRepository implements AuditLogRepository {
    private static List<AuditLog> auditLogList = new ArrayList<>();

    @Override
    public void save(AuditLog auditLog) {
        auditLogList.add(auditLog);
    }

    @Override
    public AuditLog findById(UUID id) {
        for (AuditLog auditLog : auditLogList) {
            if (auditLog.getId().equals(id)) {
                return auditLog;
            }
        }
        return null;
    }

    @Override
    public List<AuditLog> findAll() {
        return new ArrayList<>(auditLogList);
    }

    @Override
    public List<AuditLog> findByEntityType(String entityType) {
        List<AuditLog> result = new ArrayList<>();
        for (AuditLog auditLog : auditLogList) {
            if (auditLog.getEntityType().equals(entityType)) {
                result.add(auditLog);
            }
        }
        return result;
    }

}
