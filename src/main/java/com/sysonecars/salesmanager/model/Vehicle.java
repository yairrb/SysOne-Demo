package com.sysonecars.salesmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class Vehicle {

    @Id
    private Integer id;

    @ManyToOne
    private CarModel model;

    @ManyToMany
    private List<PlusMiscellaneous> plusMiscellaneous;

}
