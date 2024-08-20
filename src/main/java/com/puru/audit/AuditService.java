package com.puru.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    AuditRecordRepository auditRecordRepository;


    public List<AuditRecord> fetchAuditHistory(String entityName, String entityId) {
        List<AuditRecord> auditHistoryList = auditRecordRepository.findByEntityNameAndEntityIdOrderByUpdatedOnAsc(entityName, entityId);
        return auditHistoryList;
    }


}
