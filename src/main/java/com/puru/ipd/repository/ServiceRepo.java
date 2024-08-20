package com.puru.ipd.repository;

import com.puru.ipd.entity.master.Service;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ServiceRepo extends JpaRepositoryImplementation<Service, Long> {


//    Service findByOldSoftId(String oldSoftId);
//
//    @Transactional
//    @Modifying
//    @Query("update Service h set h.operationStatus = ?1 where h.id = ?2")
//    int updateOperationStatusById(OperationStatus operationStatus, long id);
//
//    List<Service> findByResultType(ServiceResultType resultType);
//
//    @Transactional
//    @Modifying
//    @Query("update Service s set s.documentMasterId = ?1 where s.id = ?2")
//    int updateDocumentMasterIdById(long documentMasterId, long id);
}
