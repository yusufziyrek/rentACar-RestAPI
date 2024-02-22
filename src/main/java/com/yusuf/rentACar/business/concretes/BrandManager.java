package com.yusuf.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.business.abstracts.IBrandService;
import com.yusuf.rentACar.business.requests.CreateBrandRequest;
import com.yusuf.rentACar.business.requests.UpdateBrandRequest;
import com.yusuf.rentACar.business.responses.GetAllBrandsResponse;
import com.yusuf.rentACar.business.responses.GetByIdBrandResponse;
import com.yusuf.rentACar.business.rules.BrandBusinessRules;
import com.yusuf.rentACar.core.utilites.mappers.IModelMapperService;
import com.yusuf.rentACar.dataAcces.abstracts.IBrandRepository;
import com.yusuf.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service // Bu bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements IBrandService {

	private IBrandRepository brandRepository;
	private IModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest creatBrandRequest) {

		this.brandBusinessRules.checkIfBrandNameExists(creatBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(creatBrandRequest, Brand.class);
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
