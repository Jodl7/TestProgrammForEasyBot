package com.vk.jodl7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String productType;

    @NotNull
    @NotEmpty
    private String serialNumber;

    @NotNull
    @NotEmpty
    private String manufacture;

    @NotNull
    private Double price;

    @NotNull
    @Min(value = 0, message = "stack cant be less than 0")
    private Integer stock;

    @NotNull
    @NotEmpty
    private String propertyName;

    @NotNull
    @NotEmpty
    private String propertyValue;
}