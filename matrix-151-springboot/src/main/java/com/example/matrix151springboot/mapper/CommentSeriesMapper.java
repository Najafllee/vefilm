package com.example.matrix151springboot.mapper;

import com.example.matrix151springboot.dao.CommentEntity;
import com.example.matrix151springboot.model.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentSeriesMapper {
    CommentEntity dtoToEntity(CommentDto commentDto);
    CommentDto entityToDto(CommentEntity commentEntity);

}
