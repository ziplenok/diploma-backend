package com.streamlet.diplomabackend.repository;

import com.streamlet.diplomabackend.domain.EducationalGroup;
import com.streamlet.diplomabackend.domain.EducationalProgram;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalGroupRepository extends JpaRepository<EducationalGroup, Long> {

    @Query("SELECT edugr FROM EducationalGroup edugr " +
            "JOIN EducationalProgram edup ON edup.eduGroupId = edugr.id " +
            "WHERE edup.id = ?1 ")
    EducationalGroup getEducationalGroupByEduProgram(Long pId);

    @Query("SELECT edugr FROM EducationalGroup edugr")
    List<EducationalGroup> getAllEducationalGroups();

}
