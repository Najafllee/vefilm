package com.example.matrix151springboot.mapper;
import com.example.matrix151springboot.dao.FilmEntity;
import com.example.matrix151springboot.model.FilmViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface FilmMapper{
    @Mapping(source = "comments", target = "comments")
    FilmViewDto entityToDto(FilmEntity filmEntity);
    FilmEntity dtoToEntity(FilmViewDto filmViewDto);
    FilmEntity dtoToEntity(Long id,FilmViewDto filmViewDto);

}
