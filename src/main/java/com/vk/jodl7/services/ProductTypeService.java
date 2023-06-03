package com.vk.jodl7.services;

import com.vk.jodl7.models.ProductType;

import java.util.Optional;

public interface ProductTypeService {
    Optional<ProductType> findByProductType(String productType);
}
