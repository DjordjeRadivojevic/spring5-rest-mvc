package com.springframework.spring5restmvc.repositories;

import com.springframework.spring5restmvc.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
    Vendor findByName(String name);
}
