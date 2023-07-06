package com.streamlet.diplomabackend.service.imp;


import com.streamlet.diplomabackend.domain.EducationalGroup;
import com.streamlet.diplomabackend.domain.EducationalProgram;
import com.streamlet.diplomabackend.domain.University;
import com.streamlet.diplomabackend.dto.EducationalGroupDto;
import com.streamlet.diplomabackend.dto.UniversityProgramDto;
import com.streamlet.diplomabackend.repository.EducationalGroupRepository;
import com.streamlet.diplomabackend.repository.EducationalProgramRepository;
import com.streamlet.diplomabackend.repository.SpecialityRepository;
import com.streamlet.diplomabackend.repository.UniversityRepository;
import com.streamlet.diplomabackend.service.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SpecialityServiceImp implements SpecialityService {

    private final EducationalProgramRepository educationalProgramRepository;

    private final EducationalGroupRepository educationalGroupRepository;


    private final UniversityRepository universityRepository;

    private final SpecialityRepository specialityRepository;

    @Override
    public List<EducationalGroupDto> getAllSpecialities(String language) {
        List<EducationalGroup> specialities = educationalGroupRepository.getAllEducationalGroups();

        List<EducationalGroupDto> educationalGroupDtos = new ArrayList<>(107);

        if (language.equals("ru")) {

            for (EducationalGroup speciality : specialities) {
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        speciality.getId(),
                        speciality.getCode(),
                        speciality.getNameRu(),
                        speciality.getProf1Ru(),
                        speciality.getProf2Ru()
                );

                educationalGroupDtos.add(educationalGroupDto);
            }
        }

        if (language.equals("kz")) {
            for (EducationalGroup speciality : specialities) {
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        speciality.getId(),
                        speciality.getCode(),
                        speciality.getNameKz(),
                        speciality.getProf1Kz(),
                        speciality.getProf2Kz()
                );
                educationalGroupDtos.add(educationalGroupDto);
            }
        }
        return educationalGroupDtos;
    }

    @Override
    public List<UniversityProgramDto> getSpecialityDetailsById(String language, Long eduGroupId) {

//        List<Object[]> specialityDetails = specialityRepository.getProgramAndUniversityById(eduGroupId);

        List<EducationalProgram> programs = educationalProgramRepository.getEduProgramByEduGroupId(eduGroupId);

        List<UniversityProgramDto> universityProgramDtos = new ArrayList<>();

        for (EducationalProgram program : programs) {

            University university = universityRepository.getUniversityByEduProgramId(program.getId());

            UniversityProgramDto universityProgramDto = new UniversityProgramDto(
                    university.getId(),
                    program.getId(),
                    university.getNameRu(),
                    university.getCity(),
                    program.getNameRu(),
                    program.getCode()
            );

            universityProgramDtos.add(universityProgramDto);
        }

        return universityProgramDtos;
    }


//    @Override
//    public List<SpecialityDto> getAllSpecialities(String language) {
//        List<EducationalGroup> specialities = educationalGroupRepository.getAllEducationalGroups();
//
//        List<SpecialityDto> specialityDtoList = new ArrayList<>(107);
//
//        for (EducationalGroup speciality : specialities) {
//
//            if (language.equals("ru")) {
//
//                List<Object[]> specialityDetails = specialityRepository.getProgramAndUniversityById(speciality.getId());
//
//                List<UniversityProgramDto> universityProgramDtoList = new ArrayList<>();
//
//                for (Object[] specialityDetail  : specialityDetails) {
//                    EducationalProgram educationalProgram = (EducationalProgram) specialityDetail[0];
//                    University university = (University) specialityDetail[1];
//
//                    UniversityProgramDto universityProgramDto = new UniversityProgramDto(
//                            university.getId(),
//                            educationalProgram.getId(),
//                            university.getNameRu(),
////                            university.getCode(),
//                            university.getCity(),
//                            educationalProgram.getNameRu(),
//                            educationalProgram.getCode()
//                            );
//                    universityProgramDtoList.add(universityProgramDto);
//                }
//
//                SpecialityDto specialityDto = new SpecialityDto(
//                        speciality.getId(),
//                        speciality.getCode(),
//                        speciality.getNameRu(),
//                        speciality.getProf1Ru(),
//                        speciality.getProf2Ru(),
//                        universityProgramDtoList);
//
//                specialityDtoList.add(specialityDto);
//
//            }
//
//
//        }
//
//        return specialityDtoList;
//
//    }

}
