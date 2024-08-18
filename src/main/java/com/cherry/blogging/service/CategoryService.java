package com.cherry.blogging.service;

import com.cherry.blogging.controller.CategoryController;
import com.cherry.blogging.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Integer categoryId);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void  deleteCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategories();
}
