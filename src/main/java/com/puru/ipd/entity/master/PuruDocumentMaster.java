package com.puru.ipd.entity.master;

import com.puru.carbon.enums.DocumentFormat;
import com.puru.carbon.enums.PageOrientation;
import com.puru.carbon.enums.PageSize;
import com.puru.config.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity(name = "puru_document_master")
@Table(name = "puru_document_master", indexes = {
        @Index(name = "idx_purudocumentmaster_name", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_purudocumentmaster_name", columnNames = {"name"})
})
public class PuruDocumentMaster extends Auditable<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    private PageSize pageSize;

    //height = height_in_in * 72;
    //width = width_in_in * 72;
    private int height; //print-size-Return the height, in 1/72nds of an inch, of the imageable area of the page.
    private int width;
    private PageOrientation orientation;

    /*
    File_Name.jrxml
     */
    @NotNull
    private String templateName;

    private boolean isSubReport;
    private DocumentFormat preferredFormat;

    private String srTemplateKey;
    private String srParameterMapKey;
    private String srDatasourceKey;


    public PuruDocumentMaster(String name, PageSize pageSize, PageOrientation orientation, int height, int weight, String templateName, boolean isSubReport, DocumentFormat preferredFormat) {
        this.name = name;
        this.pageSize = pageSize;
        this.orientation = orientation;
        this.templateName = templateName;
        this.isSubReport = isSubReport;
        this.preferredFormat = preferredFormat;
        this.height = height;
        this.width = weight;
    }

    /**
     * To be used only in case Sub-Report Entry
     *
     * @param name
     * @param templateName
     * @param srTemplateKey
     * @param srParameterMapKey
     * @param srDatasourceKey
     */
    public PuruDocumentMaster(String name, String templateName, String srTemplateKey, String srParameterMapKey, String srDatasourceKey) {
        this.name = name;
        this.templateName = templateName;
        this.isSubReport = true;
        this.srTemplateKey = srTemplateKey;
        this.srParameterMapKey = srParameterMapKey;
        this.srDatasourceKey = srDatasourceKey;
    }

    public PuruDocumentMaster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public PageOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(PageOrientation orientation) {
        this.orientation = orientation;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public boolean getSubReport() {
        return isSubReport;
    }

    public void setSubReport(boolean subReport) {
        isSubReport = subReport;
    }

    public DocumentFormat getPreferredFormat() {
        return preferredFormat;
    }

    public void setPreferredFormat(DocumentFormat preferredFormat) {
        this.preferredFormat = preferredFormat;
    }

    public String getSrTemplateKey() {
        return srTemplateKey;
    }

    public void setSrTemplateKey(String srTemplateKey) {
        this.srTemplateKey = srTemplateKey;
    }

    public String getSrParameterMapKey() {
        return srParameterMapKey;
    }

    public void setSrParameterMapKey(String srParameterMapKey) {
        this.srParameterMapKey = srParameterMapKey;
    }

    public String getSrDatasourceKey() {
        return srDatasourceKey;
    }

    public void setSrDatasourceKey(String srDatasourceKey) {
        this.srDatasourceKey = srDatasourceKey;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
