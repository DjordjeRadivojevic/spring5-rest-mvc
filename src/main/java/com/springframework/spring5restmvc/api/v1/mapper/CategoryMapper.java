package com.springframework.spring5restmvc.api.v1.mapper;

import com.springframework.spring5restmvc.api.v1.model.CategoryDTO;
import com.springframework.spring5restmvc.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);
}