package com.puru.audit;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "audit_record")
@Table(indexes = {
        @Index(name = "idx_auditrecord_entityname", columnList = "entityName, entityId")
})
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long audId;
    private Date updatedOn;
    private Long updatedBy;
    private String entityName;
    private String entityId;

    @Column(columnDefinition = "json")
    private String oldData;


    public Long getAudId() {
        return audId;
    }

    public void setAudId(Long audId) {
        this.audId = audId;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
