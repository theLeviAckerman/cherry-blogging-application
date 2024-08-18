package com.cherry.blogging.controller;


import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.dto.CommonApiResponse;
import com.cherry.blogging.mapper.CategoryMapper;
import com.cherry.blogging.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/fetch/{categoryId}")
    public ResponseEntity<CategoryDto> fetchCategory(@PathVariable Integer categoryId) {
        CategoryDto category = this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto category = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
       CategoryDto category =  this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<CategoryDto>> fetchAllCategories(){
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategories();
        return  new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<CommonApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategoryById(categoryId);
        CommonApiResponse apiResponse = new CommonApiResponse("Category Deleted Successfully", true,HttpStatus.OK);
        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);

    }

}
