package com.example.SpringCampBtk.business.concretes;

import com.example.SpringCampBtk.business.abstracts.ModelService;
import com.example.SpringCampBtk.business.requests.CreateModelRequest;
import com.example.SpringCampBtk.business.responses.GetAllBrandsResponse;
import com.example.SpringCampBtk.business.responses.GetAllModelsResponse;
import com.example.SpringCampBtk.core.utilities.mappers.ModelMapperService;
import com.example.SpringCampBtk.dataAccess.abstracts.BrandRepository;
import com.example.SpringCampBtk.dataAccess.abstracts.ModelRepository;
import com.example.SpringCampBtk.entities.concretes.Brand;
import com.example.SpringCampBtk.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}





























