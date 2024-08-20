package com.puru.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auditable<Long> {

//	@JsonIgnore
//	@CreatedBy
//	protected PuruUser createdBy;

//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	protected Date createdDate;

    @JsonIgnore
    @LastModifiedBy
    protected long lastModifiedBy;

//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
//	protected Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date lastTimeUpdated;


//	public Date getCreatedDate() {
//		return createdDate;
//	}

//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}


    public long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastTimeUpdated() {
        return lastTimeUpdated;
    }

    public void setLastTimeUpdated(Date lastTimeUpdated) {
        this.lastTimeUpdated = lastTimeUpdated;
    }

//	public PuruUser getCreatedBy() {
//		return createdBy;
//	}

//	public void setCreatedBy(PuruUser createdBy) {
//		this.createdBy = createdBy;
//	}

//	public PuruUser getLastModifiedBy() {
//		return lastModifiedBy;
//	}
//
//	public void setLastModifiedBy(PuruUser lastModifiedBy) {
//		this.lastModifiedBy = lastModifiedBy;
//	}
}