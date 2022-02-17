package com.api.thietbihq.service.impl;

import com.api.thietbihq.dto.CategoryDTO;
import com.api.thietbihq.entity.Category;
import com.api.thietbihq.exception.ExistException;
import com.api.thietbihq.exception.NotFoundException;
import com.api.thietbihq.mapper.CategoryMapper;
import com.api.thietbihq.repository.CategoryRepository;
import com.api.thietbihq.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream().map(category -> CategoryMapper.getInstance().toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Danh mục không tìm thấy"));
        return Optional.of(CategoryMapper.getInstance().toDTO(category));
    }

    @Override
    public Category save(CategoryDTO dto) {
        Optional<Category> category = categoryRepository.findByName(dto.getName());
        if (category.isPresent()){
            throw new ExistException("Danh mục đã tồn tại");
        }
        Category entity = CategoryMapper.getInstance().toEntity(dto);
        return categoryRepository.save(entity);
    }

    @Override
    public Category update(long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Danh mục không tìm thấy"));
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Danh mục không tìm thấy"));
        categoryRepository.delete(category);
    }
}
