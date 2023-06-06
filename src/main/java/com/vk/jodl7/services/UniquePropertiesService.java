package com.vk.jodl7.services;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.models.UniqueProperties;

import java.util.Optional;

public interface UniquePropertiesService {

    Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType);
}
