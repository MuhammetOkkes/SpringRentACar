package com.example.SpringCampBtk.business.abstracts;

import com.example.SpringCampBtk.business.abstracts.BrandService;
import com.example.SpringCampBtk.business.requests.CreateBrandRequest;
import com.example.SpringCampBtk.business.requests.UpdateBrandRequest;
import com.example.SpringCampBtk.business.responses.GetAllBrandsResponse;
import com.example.SpringCampBtk.business.responses.GetByIdBrandResponse;
import com.example.SpringCampBtk.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
