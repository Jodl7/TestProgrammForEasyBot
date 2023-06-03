package com.vk.jodl7.repositories;

import com.vk.jodl7.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Query("SELECT productType From ProductType productType WHERE productType.type = :productType")
    Optional<ProductType> findByProductType(String productType);
}
