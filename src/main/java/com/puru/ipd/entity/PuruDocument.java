package com.puru.ipd.entity;

import com.puru.carbon.enums.DocumentFormat;
import com.puru.carbon.enums.DocumentSource;
import com.puru.carbon.enums.DocumentStatus;
import com.puru.config.Auditable;
import com.puru.ipd.entity.master.PuruDocumentMaster;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
public class PuruDocument extends Auditable<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fileName;
    private String primaryKey;
    @NotNull
    private String type;

    @ManyToOne(optional = false)
    private PuruDocumentMaster master;
    private DocumentFormat format;
    @NotNull
    private DocumentSource source;
    @NotNull
    private DocumentStatus status;

    @NotNull
    private String extension;
    @NotNull
    private String httpUrl;
    @NotNull
    private String relativePath;
    @NotNull
    private String absolutePath;
    private Long ppin;
    private Long vId;
    private Long vsId;
    private int printCount;

    private String onlineUrl;
    private String relativeOnlineUrl;
    private String bucket;


    public PuruDocument() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public DocumentFormat getFormat() {
        return format;
    }

    public void setFormat(DocumentFormat format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPpin() {
        return ppin;
    }

    public void setPpin(Long ppin) {
        this.ppin = ppin;
    }

    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }

    public Long getVsId() {
        return vsId;
    }

    public void setVsId(Long vsId) {
        this.vsId = vsId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public DocumentSource getSource() {
        return source;
    }

    public void setSource(DocumentSource source) {
        this.source = source;
    }

    public int getPrintCount() {
        return printCount;
    }

    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    public PuruDocumentMaster getMaster() {
        return master;
    }

    public void setMaster(PuruDocumentMaster master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "PuruDocument{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
//                ", type='" + type + '\'' +
                ", format=" + format +
                ", extension='" + extension + '\'' +
                ", httpUrl='" + httpUrl + '\'' +
                ", relativePath='" + relativePath + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", ppin=" + ppin +
                ", vId=" + vId +
                ", vsId=" + vsId +
                '}';
    }

    public String getOnlineUrl() {
        return onlineUrl;
    }

    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl;
    }

    public String getRelativeOnlineUrl() {
        return relativeOnlineUrl;
    }

    public void setRelativeOnlineUrl(String relativeOnlineUrl) {
        this.relativeOnlineUrl = relativeOnlineUrl;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @PrePersist
    public void setStatusPrePersist() {
        this.status = DocumentStatus.VALID;
    }
}
