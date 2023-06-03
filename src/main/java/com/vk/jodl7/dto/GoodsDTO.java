package com.vk.jodl7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsDTO {

    private Long id;

    @NotNull
    private String productType;

    @NotNull
    private String serialNumber;

    @NotNull
    private String manufacture;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;

    @NotNull
    private String propertyName;

    @NotNull
    private String propertyValue;
}