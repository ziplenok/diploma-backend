package com.streamlet.diplomabackend.dto;

import java.util.List;

public record SpecialityDto(
        Long id,

        String code,

        String name,

        String prof1,

        String prof2

//        List<UniversityProgramDto> universityProgramDtoList
) {


}
