package com.streamlet.diplomabackend.dto;

import jakarta.persistence.Column;

import java.util.List;

public record UniversityDto(
        Long id,

        String name,

        String code,

        String contact_phone,

        String address,

        String url,

        String email,

        String city,

        String region,

        Integer pass_score,

        Boolean kafedra,

        Boolean dormitory
) {
}