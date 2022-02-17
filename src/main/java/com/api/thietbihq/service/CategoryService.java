package com.api.thietbihq.service;

import com.api.thietbihq.dto.CategoryDTO;
import com.api.thietbihq.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findById(long id);
    Category save(CategoryDTO dto);
    Category update(long id, CategoryDTO categoryDTO);
    void delete(long id);
}
