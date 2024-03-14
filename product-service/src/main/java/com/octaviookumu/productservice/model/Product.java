package com.octaviookumu.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id // unique identifier for product
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

// It is good practice to separate model entities and dtos
// Don't expose your model entities to the outside world
