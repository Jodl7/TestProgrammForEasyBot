package com.vk.jodl7.repositories;

import com.vk.jodl7.models.UniqueProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniquePropertiesRepository extends JpaRepository <UniqueProperties, Long> {

    @Query("SELECT uniqueProperty " +
            "FROM UniqueProperties uniqueProperty " +
            "WHERE uniqueProperty.propertyName = :propertyName " +
            "AND uniqueProperty.propertyValue = :propertyValue " +
            "AND uniqueProperty.productType.type = :productType")
    Optional<UniqueProperties> findByNameAndValueAndType(String propertyName, String propertyValue, String productType);
}
