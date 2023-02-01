package com.example.blogappapi.services;

import com.example.blogappapi.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    public void deleteCategory(Integer categoryId);

    public CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();
}
