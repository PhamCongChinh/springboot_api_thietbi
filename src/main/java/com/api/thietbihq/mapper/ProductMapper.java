package com.api.thietbihq.mapper;

import com.api.thietbihq.dto.ProductDTO;
import com.api.thietbihq.entity.Category;
import com.api.thietbihq.entity.Product;

public class ProductMapper {
    private static ProductMapper INSTANCE;

    public static ProductMapper getInstance(){
        if (INSTANCE == null){
            return new ProductMapper();
        }
        return INSTANCE;
    }
    public ProductDTO toDTO(Product product){
        ProductDTO tmp = new ProductDTO();
        tmp.setCategory_id(product.getCategory().getId());
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        return tmp;
    }

    public Product toEntity(ProductDTO productDTO, Category category){
        Product tmp = new Product();
        tmp.setCategory(category);
        tmp.setName(productDTO.getName());
        tmp.setPrice(productDTO.getPrice());
        return tmp;
    }
}
