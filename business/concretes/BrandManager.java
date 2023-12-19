package com.example.SpringCampBtk.business.concretes;

import com.example.SpringCampBtk.business.abstracts.BrandService;
import com.example.SpringCampBtk.business.requests.CreateBrandRequest;
import com.example.SpringCampBtk.business.requests.UpdateBrandRequest;
import com.example.SpringCampBtk.business.responses.GetAllBrandsResponse;
import com.example.SpringCampBtk.business.responses.GetByIdBrandResponse;
import com.example.SpringCampBtk.business.rules.BrandBusinessRules;
import com.example.SpringCampBtk.core.utilities.mappers.ModelMapperService;
import com.example.SpringCampBtk.dataAccess.abstracts.BrandRepository;
import com.example.SpringCampBtk.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}













