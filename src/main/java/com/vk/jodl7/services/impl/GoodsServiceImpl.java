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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final UniquePropertiesService uniquePropertiesService;
    private final ProductTypeService productTypeService;

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
        return goodsRepository.findByProductType(productType);
    }

    @Transactional
    public void save(GoodsDTO goods) throws NotFoundException {
        ProductType productType = productTypeService.findByProductType(goods.getProductType())
                .orElseThrow(() -> new NotFoundException("Product type not found"));
        UniqueProperties uniqueProperties = uniquePropertiesService.findByNameAndValueAndType(goods.getPropertyName(), goods.getPropertyValue(), goods.getProductType())
                .orElseGet(() -> UniqueProperties.builder()
                        .propertyName(goods.getPropertyName())
                        .propertyValue(goods.getPropertyValue())
                        .productType(productType)
                        .build());
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
    public void saveAll(List<GoodsDTO> goodsList) throws NotFoundException {

        Set<String> propName = new HashSet<>();
        Set<String> propVal = new HashSet<>();
        Set<String> prodType = new HashSet<>();

        goodsList.forEach(goods -> {
            propName.add(goods.getPropertyName());
            propVal.add(goods.getPropertyValue());
            prodType.add(goods.getProductType());
        });

        List <UniqueProperties> unique = uniquePropertiesService.findByNameAndValueAndType(propName, propVal, prodType);

        List<Goods> result = goodsList.stream()
                .map(goodsDTO -> Goods.builder()
                        .id(goodsDTO.getId())
                        .manufacture(goodsDTO.getManufacture())
                        .price(goodsDTO.getPrice())
                        .serialNumber(goodsDTO.getSerialNumber())
                        .uniqueProperty(unique.stream()
                                .filter(unq -> unq.getPropertyName().equals(goodsDTO.getPropertyName()) &&
                                        unq.getPropertyValue().equals(goodsDTO.getPropertyValue()) &&
                                        unq.getProductType().getType().equals(goodsDTO.getProductType()))
                                .findFirst()
                                .orElseThrow(/*() -> new NotFoundException("Unique property: " + goodsDTO.getPropertyName() + " " + goodsDTO.getPropertyValue() + " " + goodsDTO.getProductType() + " not found")*/))
                        .stock(goodsDTO.getStock())
                        .build())
                .collect(Collectors.toList());
        goodsRepository.saveAll(result);
    }


    @Transactional
    public void update(GoodsDTO goods) throws NotFoundException {
        goodsRepository.findById(goods.getId())
                .orElseThrow(() -> new NotFoundException("There is no product with such id"));
        this.save(goods);
    }
}
