package com.example.SpringCampBtk.business.abstracts;

import com.example.SpringCampBtk.business.requests.CreateModelRequest;
import com.example.SpringCampBtk.business.responses.GetAllBrandsResponse;
import com.example.SpringCampBtk.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);

}
