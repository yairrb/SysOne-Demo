package com.sysonecars.salesmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarModel {

    @Id
    private Integer id;

    private String modelName;

    private Double price;
}
