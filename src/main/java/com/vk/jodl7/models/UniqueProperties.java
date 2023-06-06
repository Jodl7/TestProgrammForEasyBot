package com.vk.jodl7.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "unique_properties")
public class UniqueProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prop_seq")
    @SequenceGenerator(name = "prop_seq", sequenceName = "seq_prop", allocationSize = 10)
    private Long id;

    @NotNull
    private String propertyName;

    @NotNull
    private String propertyValue;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;
}
