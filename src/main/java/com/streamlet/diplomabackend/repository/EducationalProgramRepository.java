package com.streamlet.diplomabackend.repository;

import com.streamlet.diplomabackend.domain.EducationalProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalProgramRepository
        extends JpaRepository<EducationalProgram, Long> {

    @Query("SELECT edup FROM EducationalProgram edup WHERE edup.university.id = ?1")
    List<EducationalProgram> getEduProgramByUniverId(Long universityId);

    @Query("SELECT edup FROM EducationalProgram edup")
    List<EducationalProgram> getAllEducationalPrograms();

    @Query("SELECT edup FROM EducationalProgram edup, EducationalGroup edugr " +
            "WHERE edup.eduGroupId = edugr AND edugr.prof1Ru = ?1 AND edugr.prof2Ru = ?2")
    List<EducationalProgram>getEducationalProgramsByCombinationRu(String prof1, String prof2);

    @Query("SELECT edup FROM EducationalProgram edup, EducationalGroup edugr " +
            "WHERE edup.eduGroupId = edugr AND edugr.prof1Kz = ?1 AND edugr.prof2Kz = ?2")
    List<EducationalProgram>getEducationalProgramsByCombinationKz(String prof1, String prof2);

}
