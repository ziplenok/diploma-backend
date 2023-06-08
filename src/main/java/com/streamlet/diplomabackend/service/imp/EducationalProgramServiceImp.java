package com.streamlet.diplomabackend.service.imp;


import com.streamlet.diplomabackend.domain.EducationalGroup;
import com.streamlet.diplomabackend.domain.EducationalProgram;
import com.streamlet.diplomabackend.dto.EducationalGroupDto;
import com.streamlet.diplomabackend.dto.EducationalProgramDto;
import com.streamlet.diplomabackend.repository.EducationalGroupRepository;
import com.streamlet.diplomabackend.repository.EducationalProgramRepository;
import com.streamlet.diplomabackend.service.EducationalProgramService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class EducationalProgramServiceImp implements EducationalProgramService {

    private final EducationalProgramRepository educationalProgramRepository;

    private final EducationalGroupRepository educationalGroupRepository;


    @Override
    public Map<String, List<EducationalProgramDto>> getEducationalPrograms(String language, Long universityId) {

        List<EducationalProgram> educationalPrograms =
                educationalProgramRepository.getEduProgramByUniverId(universityId);

        List<EducationalProgramDto> educationalProgramDtos = new ArrayList<>();

        for (EducationalProgram educationalProgram : educationalPrograms) {
            if (language.equals("ru")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
            if (language.equals("kz")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
        }

        Map<String, List<EducationalProgramDto>> eduProgramsByKey = educationalProgramDtos.stream()
                .collect(Collectors.groupingBy(this::getGroupingByKey,
                        Collectors.mapping((EducationalProgramDto e) -> e, toList())));

        return eduProgramsByKey;
    }

    @Override
    public List<EducationalProgramDto> getAllEducationalPrograms(String language) {

        List<EducationalProgram> educationalPrograms =
                educationalProgramRepository.getAllEducationalPrograms();

        List<EducationalProgramDto> educationalProgramDtos = new ArrayList<>();

        for (EducationalProgram educationalProgram : educationalPrograms) {
            if (language.equals("ru")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
            if (language.equals("kz")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
        }
        return educationalProgramDtos;
    }

    @Override
    public List<EducationalProgramDto> getEducationalProgramsByCombination(String language, String prof1, String prof2) {

        List<EducationalProgram> educationalPrograms = new ArrayList<>();

        if (language.equals("ru")) {
            educationalPrograms =
                    educationalProgramRepository.getEducationalProgramsByCombinationRu(prof1, prof2);
        }

        if (language.equals("kz")) {
            educationalPrograms =
                    educationalProgramRepository.getEducationalProgramsByCombinationKz(prof1, prof2);
        }

        List<EducationalProgramDto> educationalProgramDtos = new ArrayList<>();

        for (EducationalProgram educationalProgram : educationalPrograms) {
            if (language.equals("ru")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameRu(),
                        educationalGroup.getProf1Ru(),
                        educationalGroup.getProf2Ru(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
            if (language.equals("kz")) {

                EducationalGroup educationalGroup =
                        educationalGroupRepository.getEducationalGroupByEduProgram(educationalProgram.getId());
                EducationalGroupDto educationalGroupDto = new EducationalGroupDto(
                        educationalGroup.getId(),
                        educationalGroup.getCode(),
                        educationalGroup.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz()
                );

                EducationalProgramDto educationalProgramDto = new EducationalProgramDto(
                        educationalProgram.getId(),
                        educationalProgram.getCode(),
                        educationalProgram.getNameKz(),
                        educationalGroup.getProf1Kz(),
                        educationalGroup.getProf2Kz(),
                        educationalGroupDto
                );

                educationalProgramDtos.add(educationalProgramDto);
            }
        }
        return educationalProgramDtos;
    }

    private String getGroupingByKey(EducationalProgramDto eduPr) {
        return eduPr.educationalGroupDto().prof1() + " - " + eduPr.educationalGroupDto().prof2();

    }
}
