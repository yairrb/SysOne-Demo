package com.sysonecars.salesmanager.repository;

import com.sysonecars.salesmanager.model.PlusMiscellaneous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlusMiscellaneousRepository extends JpaRepository<PlusMiscellaneous, Integer> {

    public Optional<PlusMiscellaneous> findByName(String name);
}
