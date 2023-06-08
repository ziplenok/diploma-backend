package com.streamlet.diplomabackend.dto;

import com.streamlet.diplomabackend.domain.EducationalGroup;


public record EducationalProgramDto(
        Long id,

        String code,

        String name,

        String prof1,

        String prof2,

        EducationalGroupDto educationalGroupDto
) {}