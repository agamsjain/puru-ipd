package com.puru.config;

import com.puru.security.entities.PuruUser;
import com.puru.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {

    HashMap<String, Long> userIdMap = new HashMap<>();

    public SecurityAuditorAware(@Autowired UserRepository userRepo) {
        List<PuruUser> userList = userRepo.findAll();
        for (PuruUser puruUser : userList) {
            userIdMap.put(puruUser.getUsername(), puruUser.getEmployee().getLongId());
        }
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) return Optional.empty();
        String userName = authentication.getName();
        Long userId = 0l;
        if (userName != null) userId = userIdMap.getOrDefault(userName, userId);
        return Optional.of(userId);
    }
}
