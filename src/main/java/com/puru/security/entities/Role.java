package com.puru.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Role implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4274707074437014297L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<PuruUser> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    // 1-> lowest/default come handy in case of approval roles.
    private int level;

    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Role(Long id, String name, Collection<PuruUser> users, Collection<Privilege> privileges) {
        super();
        this.id = id;
        this.name = name;
        this.users = users;
        this.privileges = privileges;
    }

    public Role(Long id, String name, Collection<PuruUser> users, Collection<Privilege> privileges, int level) {
        super();
        this.id = id;
        this.name = name;
        this.users = users;
        this.privileges = privileges;
        this.level = level;
    }

    public Role(String name2) {
        this.name = name2;
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

    public Collection<PuruUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<PuruUser> users) {
        this.users = users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Role [name=" + name + ", level=" + level + "]";
    }

}