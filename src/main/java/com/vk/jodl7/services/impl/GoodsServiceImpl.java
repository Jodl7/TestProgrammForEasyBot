package com.vk.jodl7.services.impl;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.exceptions.NotFoundException;
import com.vk.jodl7.models.Goods;
import com.vk.jodl7.models.ProductType;
import com.vk.jodl7.models.UniqueProperties;
import com.vk.jodl7.repositories.GoodsRepository;
import com.vk.jodl7.services.GoodsService;
import com.vk.jodl7.services.ProductTypeService;
import com.vk.jodl7.services.UniquePropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final ProductTypeService productTypeService;
    private final UniquePropertiesService uniquePropertiesService;

    @Transactional(readOnly = true)
    public Optional<GoodsDTO> findById(Long id) throws NotFoundException {
        return goodsRepository.findById(id).stream()
                .map(pro -> {
                    GoodsDTO build = GoodsDTO.builder()
                            .id(pro.getId())
                            .manufacture(pro.getManufacture())
                            .price(pro.getPrice())
                            .productType(pro.getUniqueProperty().getProductType().getType())
                            .serialNumber(pro.getSerialNumber())
                            .stock(pro.getStock())
                            .propertyName(pro.getUniqueProperty().getPropertyName())
                            .propertyValue(pro.getUniqueProperty().getPropertyValue())
                            .build();
                    return Optional.of(build);
                })
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Transactional(readOnly = true)
    public List<GoodsDTO> findByProductType(String productType) {
        return goodsRepository.findByProductType(productType).stream()
                .map(pro -> GoodsDTO.builder()
                        .id(pro.getId())
                        .manufacture(pro.getManufacture())
                        .price(pro.getPrice())
                        .productType(pro.getUniqueProperty().getProductType().getType())
                        .serialNumber(pro.getSerialNumber())
                        .stock(pro.getStock())
                        .propertyName(pro.getUniqueProperty().getPropertyName())
                        .propertyValue(pro.getUniqueProperty().getPropertyValue())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(GoodsDTO goods) throws NotFoundException {
        UniqueProperties uniqueProperties = uniquePropertiesService.findByNameAndValueAndType(goods.getPropertyName(), goods.getPropertyValue(),goods.getProductType())
                .orElseThrow(() -> new NotFoundException("Unique property not found"));
        goodsRepository.save(Goods.builder()
                .id(goods.getId())
                .manufacture(goods.getManufacture())
                .price(goods.getPrice())
                .serialNumber(goods.getSerialNumber())
                .uniqueProperty(uniqueProperties)
                .stock(goods.getStock())
                .build());
    }

    @Transactional
    public void update(GoodsDTO goods) throws NotFoundException {
        goodsRepository.findById(goods.getId())
                .orElseThrow(() -> new NotFoundException("There is no product with such id"));
        this.save(goods);
    }
}
