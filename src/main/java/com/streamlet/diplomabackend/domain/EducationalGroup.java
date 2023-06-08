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
@Table(name = "educational_group")
public class EducationalGroup {

    @Id
    @SequenceGenerator(
            name = "educational_group_id_seq",
            sequenceName = "educational_group_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "educational_group_id_seq"
    )
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "prof1_ru")
    private String prof1Ru;

    @Column(name = "prof2_ru")
    private String prof2Ru;

    @Column(name = "name_kz")
    private String nameKz;

    @Column(name = "prof1_kz")
    private String prof1Kz;

    @Column(name = "prof2_kz")
    private String prof2Kz;

    @OneToMany(mappedBy = "eduGroupId")
    Set<EducationalProgram> educationalPrograms;
}
