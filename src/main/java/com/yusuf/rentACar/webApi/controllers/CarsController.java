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

import com.yusuf.rentACar.business.abstracts.ICarService;
import com.yusuf.rentACar.business.requests.CreateCarRequest;
import com.yusuf.rentACar.business.requests.UpdateCarRequest;
import com.yusuf.rentACar.business.responses.GetAllCarsResponse;
import com.yusuf.rentACar.business.responses.GetByIdCarResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
@Validated
public class CarsController {

	private ICarService carService;

	public CarsController(ICarService carService) {
		this.carService = carService;
	}

	@GetMapping()
	public List<GetAllCarsResponse> getAll() {
		return carService.getAll();

	}

	@GetMapping("/{id}")
	public GetByIdCarResponse getById(@PathVariable int id) {
		return carService.getById(id);

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequest carRequest) {
		this.carService.add(carRequest);

	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.carService.deleteById(id);
	}

}
