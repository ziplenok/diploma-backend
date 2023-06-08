package com.streamlet.diplomabackend.mapper;

import com.streamlet.diplomabackend.domain.University;
import com.streamlet.diplomabackend.dto.UniversityDto;
import org.mapstruct.*;

@Mapper
public interface AutoUniversityMapper {

    public UniversityDto map(University university, @Context String language);

//    protected
}
