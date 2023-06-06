package com.vk.jodl7.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_seq")
    @SequenceGenerator(name = "type_seq", sequenceName = "seq_type", allocationSize = 10)
    private Long id;

    @NotNull
    private String type;
}
