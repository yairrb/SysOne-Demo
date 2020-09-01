package com.sysonecars.salesmanager.repository;

import com.sysonecars.salesmanager.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
}
