package com.api.thietbihq.dto;

import com.api.thietbihq.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long category_id;
    private String name;
    private BigDecimal price;

    public ProductDTO(Product product){
        this.category_id = product.getCategory().getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
