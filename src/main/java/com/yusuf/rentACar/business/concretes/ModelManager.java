package com.yusuf.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.business.abstracts.IModelService;
import com.yusuf.rentACar.business.requests.CreateModelRequest;
import com.yusuf.rentACar.business.requests.UpdateModelRequest;
import com.yusuf.rentACar.business.responses.GetAllModelsResponse;
import com.yusuf.rentACar.business.responses.GetByIdModelResponse;
import com.yusuf.rentACar.business.rules.ModelBusinessRules;
import com.yusuf.rentACar.core.utilites.mappers.IModelMapperService;
import com.yusuf.rentACar.dataAcces.abstracts.IModelRepository;
import com.yusuf.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

	private IModelRepository modelRepository;
	private IModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelsResponse> getAll() {

		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponses = models.stream()
				.map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());

		return modelsResponses;
	}

	@Override
	public GetByIdModelResponse getById(int id) {

		Model model = this.modelRepository.findById(id).orElseThrow();

		GetByIdModelResponse response = this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);

		return response;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {

		this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());

		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);

	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = new Model();
		model.setName(updateModelRequest.getName());

		this.modelRepository.save(model);

	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);

	}

}
