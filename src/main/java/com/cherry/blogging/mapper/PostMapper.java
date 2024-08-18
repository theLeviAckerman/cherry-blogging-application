package com.cherry.blogging.mapper;

import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.dto.PostDto;
import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.Category;
import com.cherry.blogging.entity.Post;
import com.cherry.blogging.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, CategoryMapper.class})
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "categoryDto", target = "category")
    Post postDtoToPost(PostDto postDto);

    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "category", target = "categoryDto")
    PostDto postToPostDto(Post post);
}
