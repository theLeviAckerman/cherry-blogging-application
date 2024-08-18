package com.cherry.blogging.mapper;

import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto (User user);

    User userDtoToUser (UserDto userDto);



}
