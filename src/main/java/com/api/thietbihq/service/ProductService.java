package com.api.thietbihq.service;

import com.api.thietbihq.dto.ProductDTO;
import com.api.thietbihq.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(long id);
    Product save(ProductDTO dto);
    Product update(long id, ProductDTO dto);
    void delete(long id);
}
