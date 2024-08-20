package com.puru.security.services;

import com.puru.security.dtos.PuruUserDetail;
import com.puru.security.entities.PuruUser;
import com.puru.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PuruUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PuruUser userFromDB = userRepo.findByUsername(username);
        if (userFromDB == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        if (username.equals(userFromDB.getUsername())) {
            return new PuruUserDetail(userFromDB);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

    }


}
