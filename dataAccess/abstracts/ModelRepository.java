package com.example.SpringCampBtk.dataAccess.abstracts;

import com.example.SpringCampBtk.entities.concretes.Brand;
import com.example.SpringCampBtk.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
