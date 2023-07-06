package com.streamlet.diplomabackend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialityRepository {

    private final EntityManagerFactory emf;


    public SpecialityRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Object[]> getProgramAndUniversityById(Long edugroupId) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager
                .createQuery("SELECT edupr, u FROM  EducationalGroup edugr, EducationalProgram edupr," +
                        " University u"
                        + " WHERE edupr.eduGroupId = edugr AND edupr.university.id = u.id " +
                        "AND edugr.id = :edugroupId");
        query.setParameter("edugroupId", edugroupId);

        return query.getResultList();
    }
}
