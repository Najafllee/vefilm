package com.example.matrix151springboot.mapper;
import com.example.matrix151springboot.dao.authUser.UserEntity;
import com.example.matrix151springboot.model.AuthDtos.UserRegisterRequestDto;
import com.example.matrix151springboot.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserDto mapEntityToDto(UserEntity userEntity);
    UserEntity mapRegisterRequestDtoToEntity(UserRegisterRequestDto userRegisterRequestDto);
    UserEntity mapDtoToEntity(UserDto userDto);
    UserEntity mapDtoToEntity(UserDto userDto, Integer userId);
    List<UserDto> mapEntityToDtos(List<UserEntity> userEntities);
}
