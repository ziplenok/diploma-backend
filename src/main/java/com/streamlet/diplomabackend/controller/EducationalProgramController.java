package com.streamlet.diplomabackend.controller;


import com.streamlet.diplomabackend.dto.EducationalProgramDto;
import com.streamlet.diplomabackend.dto.UniversityDto;
import com.streamlet.diplomabackend.service.EducationalProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api_v1/programs")
@AllArgsConstructor
public class EducationalProgramController {

    private final EducationalProgramService educationalProgramService;


    @GetMapping("{language}")
    public ResponseEntity<List<EducationalProgramDto>> getAllPrograms(@PathVariable("language") String language) {
        List<EducationalProgramDto> programList = educationalProgramService.getAllEducationalPrograms(language);
        return new ResponseEntity<>(programList, HttpStatus.OK);
    }
}
