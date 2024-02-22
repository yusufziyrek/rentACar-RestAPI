package com.yusuf.rentACar.business.abstracts;

import java.util.List;

import com.yusuf.rentACar.business.requests.CreateBrandRequest;
import com.yusuf.rentACar.business.requests.UpdateBrandRequest;
import com.yusuf.rentACar.business.responses.GetAllBrandsResponse;
import com.yusuf.rentACar.business.responses.GetByIdBrandResponse;

public interface IBrandService {

	List<GetAllBrandsResponse> getAll();

	GetByIdBrandResponse getById(int id);

	void add(CreateBrandRequest creatBrandRequest);

	void update(UpdateBrandRequest updateBrandRequest);

	void delete(int id);

}
