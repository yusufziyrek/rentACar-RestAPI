package com.yusuf.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.rentACar.business.abstracts.IBrandService;
import com.yusuf.rentACar.business.requests.CreateBrandRequest;
import com.yusuf.rentACar.business.requests.UpdateBrandRequest;
import com.yusuf.rentACar.business.responses.GetAllBrandsResponse;
import com.yusuf.rentACar.business.responses.GetByIdBrandResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/brands")
@Validated
public class BrandsController {

	private IBrandService brandService;

	@Autowired
	public BrandsController(IBrandService brandService) {
		this.brandService = brandService;

	}

	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return this.brandService.getAll();

	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return this.brandService.getById(id);

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid CreateBrandRequest creatBrandRequest) {
		this.brandService.add(creatBrandRequest);

	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);

	}

}
