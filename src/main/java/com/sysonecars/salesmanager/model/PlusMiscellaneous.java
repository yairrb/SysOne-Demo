package com.sysonecars.salesmanager.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class PlusMiscellaneous {

    @Id
    private Integer id;

    private String name;

    private Double price;

}
