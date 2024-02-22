package com.yusuf.rentACar.business.abstracts;

import java.util.List;

import com.yusuf.rentACar.business.requests.CreateModelRequest;
import com.yusuf.rentACar.business.requests.UpdateModelRequest;
import com.yusuf.rentACar.business.responses.GetAllModelsResponse;
import com.yusuf.rentACar.business.responses.GetByIdModelResponse;

public interface IModelService {
	
	List<GetAllModelsResponse> getAll();
	
	GetByIdModelResponse getById(int id);
	
	void update(UpdateModelRequest updateModelRequest);
	
	void add(CreateModelRequest createModelRequest);
	
	void delete(int id);

}
