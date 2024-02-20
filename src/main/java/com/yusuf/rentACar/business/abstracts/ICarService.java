package com.yusuf.rentACar.business.abstracts;

import java.util.List;

import com.yusuf.rentACar.business.requests.CreateCarRequest;
import com.yusuf.rentACar.business.responses.GetAllCarsResponse;
import com.yusuf.rentACar.business.responses.GetByIdCarResponse;

public interface ICarService {

	List<GetAllCarsResponse> getAll();

	GetByIdCarResponse getById(int id);

	void add(CreateCarRequest createCarRequest);

	void deleteById(int id);

}
