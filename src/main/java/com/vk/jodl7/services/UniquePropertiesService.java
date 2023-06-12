package com.vk.jodl7.services;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.models.UniqueProperties;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UniquePropertiesService {

    Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType);

    List<UniqueProperties> findByNameAndValueAndType(Set<String> propertyName, Set<String> propertyValue, Set<String> productType);
}
