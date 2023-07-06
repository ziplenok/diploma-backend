package com.streamlet.diplomabackend.service;

import com.streamlet.diplomabackend.dto.EducationalProgramDto;

import java.util.List;
import java.util.Map;

public interface EducationalProgramService {

    Map<String, List<EducationalProgramDto>> getEducationalPrograms(String language, Long universityId);

    List<EducationalProgramDto> getAllEducationalPrograms(String language);

    List<EducationalProgramDto> getEducationalProgramsByCombination(String language, String pro1, String prof2);

//    List<>
}
