package com.sysonecars.salesmanager.vehicle;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {

    private Integer id;

    private String VehicleModel;

    private List<String> plusOptionals;

    private Double price;
}
