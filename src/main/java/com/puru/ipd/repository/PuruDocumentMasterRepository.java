package com.puru.ipd.repository;

import com.puru.ipd.entity.master.PuruDocumentMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PuruDocumentMasterRepository extends JpaRepository<PuruDocumentMaster, Long> {
    Optional<PuruDocumentMaster> findFirstByNameOrderByIdDesc(String name);

    boolean existsByName(String name);

    PuruDocumentMaster findByName(String name);
}