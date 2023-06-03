package com.vk.jodl7.repositories;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query("SELECT new com.vk.jodl7.dto.GoodsDTO(goods.id, " +
            "prodType.type, " +
            "goods.serialNumber, " +
            "goods.manufacture, " +
            "goods.price, " +
            "goods.stock, " +
            "unProp.propertyName, " +
            "unProp.propertyValue) " +
            "FROM Goods goods " +
            "join UniqueProperties unProp on goods.uniqueProperty.id = unProp.id " +
            "join ProductType prodType on unProp.productType.id = prodType.id " +
            "WHERE prodType.type = :productType")
    List<GoodsDTO> findByProductType(String productType);
}
