package com.vk.jodl7.services.impl;

import com.vk.jodl7.models.ProductType;
import com.vk.jodl7.repositories.ProductTypeRepository;
import com.vk.jodl7.services.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public Optional<ProductType> findByProductType(String productType) {
        return productTypeRepository.findByProductType(productType);
    }
}
