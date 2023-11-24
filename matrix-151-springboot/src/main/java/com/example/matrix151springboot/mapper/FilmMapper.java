package com.example.matrix151springboot.mapper;

import com.example.matrix151springboot.dao.FilmEntity;
import com.example.matrix151springboot.model.FilmViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    FilmViewDto entityToDto(FilmEntity filmEntity);

    FilmEntity dtoToEntity(FilmViewDto filmViewDto);

    FilmEntity dtoToEntity(Long id, FilmViewDto filmViewDto);

}
