package com.streamlet.diplomabackend.repository;

import com.streamlet.diplomabackend.domain.EducationalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalGroupRepository extends JpaRepository<EducationalGroup, Long> {

    @Query("SELECT edugr FROM EducationalGroup edugr " +
            "JOIN EducationalProgram edup ON edup.eduGroupId = edugr.id " +
            "WHERE edup.id = ?1 ")
    EducationalGroup getEducationalGroupByEduProgram(Long pId);
}
