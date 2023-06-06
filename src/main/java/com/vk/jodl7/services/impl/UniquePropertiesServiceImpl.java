package com.vk.jodl7.services.impl;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.models.UniqueProperties;
import com.vk.jodl7.repositories.UniquePropertiesRepository;
import com.vk.jodl7.services.UniquePropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniquePropertiesServiceImpl implements UniquePropertiesService {
    private final UniquePropertiesRepository uniquePropertiesRepository;

    @Override
    public Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType) {
        return uniquePropertiesRepository.findByNameAndValueAndType(propertyName, propertyValue, productType);
    }

}
