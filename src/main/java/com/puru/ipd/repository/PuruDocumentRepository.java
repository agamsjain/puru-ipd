package com.puru.ipd.repository;

import com.puru.carbon.enums.DocumentStatus;
import com.puru.ipd.entity.PuruDocument;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public interface PuruDocumentRepository extends JpaRepository<PuruDocument, Long> {
    List<PuruDocument> findByVsId(Long vsId);

    List<PuruDocument> findAllByLastTimeUpdatedBetween(Date startDate, Date endDate);

//    	List<VisitSession> findAllByPathoTrueAndDateTimeBetweenAndStatusPathoIn(Date startDate, Date endDate, List<HASConstant.VisitSessionPathoStatus> pathoStatus);


    //@Override
    HashSet<PuruDocument> findAllByTypeAndPrimaryKey(String type, String primaryKey);

    @Transactional
    @Modifying
    @Query("update PuruDocument d set d.printCount = d.printCount + 1 where d.id = :id")
    void incrementPrintCount(Long id);

    @Query("select d.printCount from PuruDocument d where d.id = :id")
    int getPrintCountForDocument(Long id);

    @Query("select pd from PuruDocument pd where pd.vId = :vId")
    List<PuruDocument> findAllByVId(Long vId);

    @Modifying
    @Transactional
    @Query("update PuruDocument  d set d.status = ?1 where d.primaryKey = ?2 and d.type in ?3")
    int updateStatusByPrimaryKeyAndType(DocumentStatus status, String primaryKey, List<String> type);
}