package com.example.SpringCampBtk.webApi.controllers;

import com.example.SpringCampBtk.business.abstracts.BrandService;
import com.example.SpringCampBtk.business.requests.CreateBrandRequest;
import com.example.SpringCampBtk.business.requests.UpdateBrandRequest;
import com.example.SpringCampBtk.business.responses.GetAllBrandsResponse;
import com.example.SpringCampBtk.business.responses.GetByIdBrandResponse;
import com.example.SpringCampBtk.entities.concretes.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {


        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}


