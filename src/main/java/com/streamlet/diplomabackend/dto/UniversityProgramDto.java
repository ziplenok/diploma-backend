package com.streamlet.diplomabackend.dto;

public record UniversityProgramDto(

        Long universityId,

        Long programId,

        String universityName,

        String city,

        String programName,

        String programCode
) {
}
