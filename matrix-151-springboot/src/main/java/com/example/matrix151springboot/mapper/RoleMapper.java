package com.example.matrix151springboot.mapper;
import com.example.matrix151springboot.dao.authUser.RoleEntity;
import com.example.matrix151springboot.model.authDtos.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@SuppressWarnings("all")
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper mapper = Mappers.getMapper(RoleMapper.class);

    RoleEntity mapDtoToEntity(RoleDto roleDto);
    RoleDto mapEntityToDto(RoleEntity roleEntity);
}
