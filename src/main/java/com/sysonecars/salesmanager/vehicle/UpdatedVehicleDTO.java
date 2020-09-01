package com.sysonecars.salesmanager.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatedVehicleDTO {

    Integer id;

    Integer model;

    List<Integer> miscellaneous;
}
