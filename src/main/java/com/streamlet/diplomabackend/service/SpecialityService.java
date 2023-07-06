package com.streamlet.diplomabackend.service;

import com.streamlet.diplomabackend.dto.EducationalGroupDto;
import com.streamlet.diplomabackend.dto.SpecialityDto;
import com.streamlet.diplomabackend.dto.UniversityProgramDto;

import java.util.List;

public interface SpecialityService {

    List<EducationalGroupDto> getAllSpecialities(String language);

    List<UniversityProgramDto> getSpecialityDetailsById(String language, Long eduGroupId);
}
