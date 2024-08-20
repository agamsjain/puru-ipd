package com.puru.security.repo;

import com.puru.security.entities.Privilege;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PrivledgeRepository extends JpaRepositoryImplementation<Privilege, Long> {

    Privilege findByName(String name);

}
