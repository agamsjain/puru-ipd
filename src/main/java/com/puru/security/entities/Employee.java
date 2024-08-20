package com.puru.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.io.Serializable;

@Entity
@Table(indexes = {
        @Index(name = "idx_longId", columnList = "longId"),
        @Index(name = "idx_email", columnList = "email")
})
public class Employee implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5989218356130679315L;
    @Id
    @Column(length = 20)
    private String employeeId;
    private long longId;
    private String salutation;

    // SEPARTE NAME INTO THREE SEGMENT.
    private boolean married;
    @Column(length = 1)
    private String gender;
    private String name;
    private String middleName;
    private String lastName;
    private boolean active;
    private boolean consultant;
    private String fullName;
    private EmployeeStatus status;

    @Column(length = 2)
    private String shortcutKey;

    @Email
    private String email;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private PuruUser updatedBy;
    private boolean puruUserStatus;
    private String designation;
    private String category;

    public Employee() {
        super();
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PuruUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(PuruUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPuruUserStatus() {
        return puruUserStatus;
    }

    public void setPuruUserStatus(boolean puruUserStatus) {
        this.puruUserStatus = puruUserStatus;
    }

    public long getLongId() {
        return longId;
    }

    public void setLongId(long longId) {
        this.longId = longId;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean getConsultant() {
        return consultant;
    }

    public void setConsultant(boolean consultant) {
        this.consultant = consultant;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getShortcutKey() {
        return shortcutKey;
    }

    public void setShortcutKey(String shortcutKey) {
        this.shortcutKey = shortcutKey;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
