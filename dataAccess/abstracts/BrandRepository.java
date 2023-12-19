package com.example.SpringCampBtk.dataAccess.abstracts;

import com.example.SpringCampBtk.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}

