package com.puru.security.services;

import com.puru.security.entities.PuruUser;
import com.puru.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PuruUserService {

    @Autowired
    private UserRepository userRepo;

    @Cacheable("getCurrentUserFromPricipal")
    public PuruUser getCurrentUserFromPricipal(Principal user) {
        PuruUser updatedBy = userRepo.findByUsername(user.getName());
        return updatedBy;
    }

    public PuruUser getUserForAutoEntry() {
        PuruUser updatedBy = userRepo.findById(1L).get();
        return updatedBy;
    }

    @Cacheable("findByUsername")
    public PuruUser findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
