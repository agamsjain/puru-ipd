package com.puru.security.repo;

import com.puru.security.entities.PuruUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserRepository extends JpaRepositoryImplementation<PuruUser, Long> {

    @EntityGraph(value = "graph.PuruUser.GetAfterLogin", type = EntityGraph.EntityGraphType.LOAD)
    PuruUser findByUsername(String username);

}
