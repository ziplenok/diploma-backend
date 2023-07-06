package com.streamlet.diplomabackend.service.imp;

import com.streamlet.diplomabackend.domain.EducationalProgram;
import com.streamlet.diplomabackend.domain.University;
import com.streamlet.diplomabackend.dto.UniversityDto;
import com.streamlet.diplomabackend.repository.UniversityRepository;
import com.streamlet.diplomabackend.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UniversityServiceImp implements UniversityService {

    private final UniversityRepository universityRepository;

    @Override
    public List<UniversityDto> getUniversities(String language) {

        List<University> universities = universityRepository.getAll();

        //TODO check for emptiness
//        if(universities.isEmpty()) throw

        List<UniversityDto> universityDtos = new ArrayList<>(100);

        for(University university : universities) {
            if (language.equals("ru") && university.getIsActive()) {

                UniversityDto universityDTO = new UniversityDto(
                        university.getId(),
                        university.getNameRu(),
                        university.getCode(),
                        university.getContactPhone(),
                        university.getAddressRu(),
                        university.getUrl(),
                        university.getEmail(),
                        university.getCity(),
                        university.getRegion(),
                        university.getPassScore(),
                        university.getKafedra(),
                        university.getDormitory(),
                        university.getInPrediction()
                );
                universityDtos.add(universityDTO);
            }

            if (language.equals("kz") && university.getIsActive()) {

                UniversityDto universityDTO = new UniversityDto(
                        university.getId(),
                        university.getNameKz(),
                        university.getCode(),
                        university.getContactPhone(),
                        university.getAddressKz(),
                        university.getUrl(),
                        university.getEmail(),
                        university.getCity(),
                        university.getRegion(),
                        university.getPassScore(),
                        university.getKafedra(),
                        university.getDormitory(),
                        university.getInPrediction()
                );

                universityDtos.add(universityDTO);
            }
        }

        return universityDtos;
    }
}
