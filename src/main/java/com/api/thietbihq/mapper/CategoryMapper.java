package com.api.thietbihq.mapper;

import com.api.thietbihq.dto.CategoryDTO;
import com.api.thietbihq.entity.Category;

public class CategoryMapper {
    private static CategoryMapper INSTANCE;

    public static CategoryMapper getInstance() {
        if (INSTANCE == null){
            return new CategoryMapper();
        }
        return INSTANCE;
    }

    public CategoryDTO toDTO(Category category){
        CategoryDTO tmp = new CategoryDTO();
        tmp.setId(category.getId());
        tmp.setName(category.getName());
        return tmp;
    }

    public Category toEntity(CategoryDTO categoryDTO){
        Category tmp = new Category();
        tmp.setName(categoryDTO.getName());
        return tmp;
    }
}
