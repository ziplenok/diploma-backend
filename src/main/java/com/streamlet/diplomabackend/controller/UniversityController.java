package com.streamlet.diplomabackend.controller;

import com.streamlet.diplomabackend.domain.EducationalProgram;
import com.streamlet.diplomabackend.dto.EducationalProgramDto;
import com.streamlet.diplomabackend.dto.UniversityDto;
import com.streamlet.diplomabackend.service.EducationalProgramService;
import com.streamlet.diplomabackend.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api_v1/universities")
@AllArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    private final EducationalProgramService educationalProgramService;

    @GetMapping("{language}")
    public ResponseEntity<List<UniversityDto>> getUniversities(@PathVariable("language") String language) {
        List<UniversityDto> universityList = universityService.getUniversities(language);
        return new ResponseEntity<>(universityList, HttpStatus.OK);
    }

    @GetMapping("{language}/{universityId}")
    public ResponseEntity<Map<String, List<EducationalProgramDto>>> getEducationalProgram(@PathVariable("language")String language,
                                                                       @PathVariable("universityId")Long universityId) {
        Map<String, List<EducationalProgramDto>> educationalProgramDtos =
                educationalProgramService.getEducationalPrograms(language, universityId);

        return new ResponseEntity<>(educationalProgramDtos, HttpStatus.OK);
    }
}
