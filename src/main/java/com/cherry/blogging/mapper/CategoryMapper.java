package com.cherry.blogging.mapper;

import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.entity.Category;
import com.cherry.blogging.service.CategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToDto(Category category);

    Category dtoToCategory(CategoryDto CategoryDto);
}
