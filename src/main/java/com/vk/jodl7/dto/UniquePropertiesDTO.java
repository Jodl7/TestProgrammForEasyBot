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
public class UniquePropertiesDTO {

    private Long id;

    @NotNull
    private String propertyName;

    @NotNull
    private String propertyValue;

    private String productType;
}
