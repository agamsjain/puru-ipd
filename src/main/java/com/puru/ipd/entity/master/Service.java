package com.puru.ipd.entity.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.puru.carbon.enums.PrintMode;
import com.puru.carbon.enums.ServiceResultType;
import com.puru.ipd.super_entity.PuruService;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name = "idx_sClass", columnList = "sClass"),
        @Index(name = "idx_sClassName", columnList = "name, sClass"),
        @Index(name = "idx_service_internal", columnList = "internal")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_service_name", columnNames = {"name"})
})
public class Service extends PuruService implements Serializable {

    private ServiceResultType resultType;
    private String oldSoftId;


    public Service() {
        super();
    }

    public ServiceResultType getResultType() {
        return resultType;
    }

    public void setResultType(ServiceResultType resultType) {
        this.resultType = resultType;
    }

    public String getOldSoftId() {
        return oldSoftId;
    }

    public void setOldSoftId(String oldSoftId) {
        this.oldSoftId = oldSoftId;
    }
}
