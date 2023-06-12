package com.vk.jodl7.services.impl;

import com.vk.jodl7.models.UniqueProperties;
import com.vk.jodl7.repositories.UniquePropertiesRepository;
import com.vk.jodl7.services.UniquePropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UniquePropertiesServiceImpl implements UniquePropertiesService {
    private final UniquePropertiesRepository uniquePropertiesRepository;

    @Override
    public List<UniqueProperties> findByNameAndValueAndType(Set<String> propertyName, Set<String> propertyValue, Set<String> productType) {
        return uniquePropertiesRepository.findByNameAndValueAndType(propertyName, propertyValue, productType);
    }

    @Override
    public Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType) {
        return uniquePropertiesRepository.findByNameAndValueAndType(propertyName, propertyValue, productType);
    }

}
