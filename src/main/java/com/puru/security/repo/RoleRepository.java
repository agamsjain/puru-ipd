package com.puru.security.repo;

import com.puru.security.entities.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface RoleRepository extends JpaRepositoryImplementation<Role, Long> {

    Role findByName(String name);

    Role findByNameAndLevel(String name, int level);

}
