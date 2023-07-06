package com.streamlet.diplomabackend.controller;


import com.streamlet.diplomabackend.dto.EducationalGroupDto;
import com.streamlet.diplomabackend.dto.SpecialityDto;
import com.streamlet.diplomabackend.dto.UniversityDto;
import com.streamlet.diplomabackend.dto.UniversityProgramDto;
import com.streamlet.diplomabackend.service.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api_v1/specialities")
@AllArgsConstructor
public class SpecialityController {

    private final SpecialityService specialityService;

//    @GetMapping("{language}")
//    public ResponseEntity<List<SpecialityDto>> getSpecialities(@PathVariable("language") String language) {
//        List<SpecialityDto> specialityDtos = specialityService.getAllSpecialities(language);
//        return new ResponseEntity<>(specialityDtos, HttpStatus.OK);
//    }

    @GetMapping("{language}")
    public ResponseEntity<List<EducationalGroupDto>> getSpecialities(@PathVariable("language") String language) {
        List<EducationalGroupDto> specialityDtos = specialityService.getAllSpecialities(language);
        return new ResponseEntity<>(specialityDtos, HttpStatus.OK);
    }

    @GetMapping("{language}/{eduGroupId}")
    public ResponseEntity<List<UniversityProgramDto>> getSpecialities(@PathVariable("language") String language,
                                                                      @PathVariable("eduGroupId")Long eduGroupId) {
        List<UniversityProgramDto> specialityDetails = specialityService.getSpecialityDetailsById(language, eduGroupId);
        return new ResponseEntity<>(specialityDetails, HttpStatus.OK);
    }
}
