package com.streamlet.diplomabackend.service;

import com.streamlet.diplomabackend.dto.UniversityDto;

import java.util.List;

public interface UniversityService {

    List<UniversityDto> getUniversities(String language);
}
