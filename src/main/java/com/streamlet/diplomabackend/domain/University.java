package com.streamlet.diplomabackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="university")
public class University {
    @Id
    @SequenceGenerator(
            name = "univer_id_seq",
            sequenceName = "univer_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "univer_id_seq"
    )
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_kz")
    private String nameKz;

    @Column(name = "code")
    private String code;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address_ru")
    private String addressRu;

    @Column(name = "address_kz")
    private String addressKz;

    @Column(name = "url")
    private String url;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "pass_score")
    private Integer passScore;

    @Column(name = "kafedra")
    private Boolean kafedra;

    @Column(name = "dormitory")
    private Boolean dormitory;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "university")
    Set<EducationalProgram> educationalPrograms;
}
