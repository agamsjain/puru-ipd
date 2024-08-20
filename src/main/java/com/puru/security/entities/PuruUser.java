package com.puru.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@NamedEntityGraph(name = "graph.PuruUser.GetAfterLogin", attributeNodes = {@NamedAttributeNode(value = "roles")})
@Entity
public class PuruUser implements Serializable {

    private static final long serialVersionUID = -6892792219594554175L;

    @Id
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private boolean enabled;

    @OneToOne
    @JoinColumn(nullable = false, name = "employee_id")
    private Employee employee;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private PuruUser updatedBy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public PuruUser() {
        super();
    }

    public PuruUser(Employee employee, String username,
                    String password, boolean enabled, Collection<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.employee = employee;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public PuruUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(PuruUser updatedBy) {
        this.updatedBy = updatedBy;
    }


    @Override
    public String toString() {
        return "PuruUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}