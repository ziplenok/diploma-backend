package com.streamlet.diplomabackend.repository;

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
}
