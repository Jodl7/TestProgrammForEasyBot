package com.vk.jodl7.services.impl;

import com.vk.jodl7.models.UniqueProperties;
import com.vk.jodl7.repositories.UniquePropertiesRepository;
import com.vk.jodl7.services.UniquePropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniquePropertiesServiceImpl implements UniquePropertiesService {
    private final UniquePropertiesRepository uniquePropertiesRepository;

    @Override
    public List<UniqueProperties> findByNameAndValueAndType(List<String> propertyName, List<String> propertyValue, List<String> productType) {
        return uniquePropertiesRepository.findByNameAndValueAndType(propertyName, propertyValue, productType);
    }

}
