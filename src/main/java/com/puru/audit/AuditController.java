package com.puru.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/history/{entityName}/{id}")
    public List getHistory(@PathVariable String entityName, @PathVariable String id) {
                return auditService.fetchAuditHistory(entityName, id);
    }
}
