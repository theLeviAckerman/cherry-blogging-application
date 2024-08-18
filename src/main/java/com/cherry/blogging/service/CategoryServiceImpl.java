package com.cherry.blogging.service;

import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.entity.Category;
import com.cherry.blogging.execption.ResourceNotFoundException;
import com.cherry.blogging.mapper.CategoryMapper;
import com.cherry.blogging.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category save = this.categoryRepo.save(CategoryMapper.INSTANCE.dtoToCategory(categoryDto));
        return CategoryMapper.INSTANCE.categoryToDto(save);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        return CategoryMapper.INSTANCE.categoryToDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setTitle(category.getTitle());
        category.setDescription(categoryDto.getDescription());
        Category savedCategory = this.categoryRepo.save(category);
        return CategoryMapper.INSTANCE.categoryToDto(savedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = this.categoryRepo.findAll();
        return categoryList.stream().map(CategoryMapper.INSTANCE::categoryToDto).collect(Collectors.toList());
    }
}
