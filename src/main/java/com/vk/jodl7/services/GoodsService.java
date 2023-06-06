package com.vk.jodl7.services;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface GoodsService {
    Optional<GoodsDTO> findById(Long id) throws NotFoundException;

    List<GoodsDTO> findByProductType(String productType);

    void saveAll(List<GoodsDTO> goodsDTO) throws NotFoundException;

    void save(GoodsDTO goodsDTO) throws NotFoundException;

    void update(GoodsDTO goods) throws NotFoundException;
}
