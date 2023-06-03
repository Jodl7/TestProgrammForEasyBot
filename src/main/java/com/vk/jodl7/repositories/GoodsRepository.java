package com.vk.jodl7.repositories;

import com.vk.jodl7.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query("SELECT goods FROM Goods goods WHERE goods.uniqueProperty.productType.type = :productType")
    List<Goods> findByProductType(String productType);
}
