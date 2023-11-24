package com.example.matrix151springboot.mapper;

import com.example.matrix151springboot.dao.SeriesEntity;
import com.example.matrix151springboot.model.SeriesViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    SeriesViewDto entityToDto(SeriesEntity seriesEntity);

    @Mapping(source = "nameOfSeries", target = "nameOfSeries")
    SeriesEntity dtoToEntity(SeriesViewDto seriesViewDto);

    SeriesEntity dtoToEntity(Long id, SeriesViewDto seriesViewDto);
}
