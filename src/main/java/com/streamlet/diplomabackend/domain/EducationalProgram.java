package com.streamlet.diplomabackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "educational_program")
public class EducationalProgram {

    @Id
    @SequenceGenerator(
            name = "educational_programs_id_seq",
            sequenceName = "educational_programs_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "educational_programs_id_seq"
    )
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_kz")
    private String nameKz;

    @ManyToOne
    @JoinColumn(name = "edu_group_id", nullable=false)
    EducationalGroup eduGroupId;

    @ManyToOne
    @JoinColumn(name = "univer_id", nullable=false)
    University university;
}
