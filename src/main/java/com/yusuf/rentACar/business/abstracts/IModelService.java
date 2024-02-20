package com.yusuf.rentACar.business.abstracts;

import java.util.List;

import com.yusuf.rentACar.business.requests.CreateModelRequest;
import com.yusuf.rentACar.business.responses.GetAllModelsResponse;

public interface IModelService {
	
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);

}
