package com.puru.ipd.super_entity;

import com.puru.carbon.enums.OperationStatus;
import com.puru.carbon.enums.ServiceType;
import com.puru.config.Auditable;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class PuruService extends Auditable<Long> implements Serializable {
    @Id
    private long id;
    private String name;
    private String sClass;
    private ServiceType type;
    private String description;
    private String icon;
    private String docId;
    private boolean internal;
    private boolean subServicePresent;
    private boolean allowedFromWeb;
    private boolean multipleQtyAllowed;
    private OperationStatus operationStatus;

    public PuruService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public boolean isSubServicePresent() {
        return subServicePresent;
    }

    public void setSubServicePresent(boolean subServicePresent) {
        this.subServicePresent = subServicePresent;
    }

    public boolean isAllowedFromWeb() {
        return allowedFromWeb;
    }

    public void setAllowedFromWeb(boolean allowedFromWeb) {
        this.allowedFromWeb = allowedFromWeb;
    }

    public boolean isMultipleQtyAllowed() {
        return multipleQtyAllowed;
    }

    public void setMultipleQtyAllowed(boolean multipleQtyAllowed) {
        this.multipleQtyAllowed = multipleQtyAllowed;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }
}
