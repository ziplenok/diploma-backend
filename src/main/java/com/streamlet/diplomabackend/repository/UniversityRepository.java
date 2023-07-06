package com.streamlet.diplomabackend.repository;

import com.streamlet.diplomabackend.domain.EducationalProgram;
import com.streamlet.diplomabackend.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    @Query("SELECT u FROM University u")
    List<University> getAll();

    @Query("SELECT u FROM University u, EducationalProgram edup WHERE u.id = edup.university.id " +
            "AND edup.id = ?1")
    University getUniversityByEduProgramId(Long eduProgramId);
}
