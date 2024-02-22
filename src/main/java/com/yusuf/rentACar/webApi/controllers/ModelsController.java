package com.yusuf.rentACar.webApi.controllers;

import java.util.List;

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

import com.yusuf.rentACar.business.abstracts.IModelService;
import com.yusuf.rentACar.business.requests.CreateModelRequest;
import com.yusuf.rentACar.business.requests.UpdateModelRequest;
import com.yusuf.rentACar.business.responses.GetAllModelsResponse;
import com.yusuf.rentACar.business.responses.GetByIdModelResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/models")
@Validated
public class ModelsController {

	private IModelService modelService;

	public ModelsController(IModelService modelService) {
		this.modelService = modelService;
	}

	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return this.modelService.getAll();

	}

	@GetMapping("/{id}")
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.getById(id);

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);

	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);

	}

	@DeleteMapping()
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);

	}

}
