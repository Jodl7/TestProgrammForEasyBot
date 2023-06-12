package com.vk.jodl7.services;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.models.UniqueProperties;

import java.util.List;
import java.util.Optional;

public interface UniquePropertiesService {

    Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType);

    Optional<UniqueProperties> findByNameAndValueAndType(List<String> propertyName, List<String> propertyValue, List<String> productType);
}
