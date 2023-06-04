package com.vk.jodl7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniquePropertiesDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String propertyName;

    @NotNull
    @NotEmpty
    private String propertyValue;

    private String productType;
}
