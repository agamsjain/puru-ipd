package com.puru.security.dtos;

import com.puru.security.entities.Privilege;
import com.puru.security.entities.PuruUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PuruUserDetail extends PuruUser implements UserDetails {

    private static final long serialVersionUID = 6585836515617917616L;

    public PuruUserDetail() {
        super();
    }

    public PuruUserDetail(PuruUser user) {
        super(user.getEmployee(), user.getUsername(), user.getPassword(), user.isEnabled(), user.getRoles());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Privilege> listOfAuthrities = new ArrayList<Privilege>();
        getRoles().forEach(r -> {
            r.getPrivileges().forEach(p -> {
                if (!listOfAuthrities.contains(p)) {
                    listOfAuthrities.add(p);
                }
            });
        });
        return listOfAuthrities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return getEmployee().isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getEmployee().isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
