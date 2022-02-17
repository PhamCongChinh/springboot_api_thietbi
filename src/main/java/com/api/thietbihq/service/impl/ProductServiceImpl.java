package com.api.thietbihq.service.impl;

import com.api.thietbihq.dto.ProductDTO;
import com.api.thietbihq.entity.Category;
import com.api.thietbihq.entity.Product;
import com.api.thietbihq.exception.NotFoundException;
import com.api.thietbihq.mapper.ProductMapper;
import com.api.thietbihq.repository.CategoryRepository;
import com.api.thietbihq.repository.ProductRepository;
import com.api.thietbihq.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream().map(product -> ProductMapper.getInstance().toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sản phẩm không tìm thấy"));
        return Optional.of(ProductMapper.getInstance().toDTO(product));
    }

    @Override
    public Product save(ProductDTO dto) {
        Category category = categoryRepository.findById(dto.getCategory_id())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy danh mục"));
        Product product = ProductMapper.getInstance().toEntity(dto, category);
        return productRepository.save(product);
    }

    @Override
    public Product update(long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm"));
        //product.getCategory().setId(productDTO.getCategory_id());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sản phẩm không tìm thấy"));
        productRepository.delete(product);
    }
}
