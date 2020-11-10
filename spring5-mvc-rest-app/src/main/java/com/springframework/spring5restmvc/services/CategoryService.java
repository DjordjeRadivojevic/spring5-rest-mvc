package com.springframework.spring5restmvc.services;

import com.springframework.spring5restmvc.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}