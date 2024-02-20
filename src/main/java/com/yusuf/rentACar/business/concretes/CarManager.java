package com.yusuf.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.business.abstracts.ICarService;
import com.yusuf.rentACar.business.requests.CreateCarRequest;
import com.yusuf.rentACar.business.responses.GetAllCarsResponse;
import com.yusuf.rentACar.business.responses.GetByIdCarResponse;
import com.yusuf.rentACar.business.rules.CarBusinessRules;
import com.yusuf.rentACar.core.utilites.mappers.IModelMapperService;
import com.yusuf.rentACar.dataAcces.abstracts.ICarRepository;
import com.yusuf.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements ICarService {

	private ICarRepository carRepository;
	private IModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarsResponse> getAll() {

		List<Car> cars = carRepository.findAll();

		List<GetAllCarsResponse> carsResponses = cars.stream()
				.map(car -> modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());

		return carsResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {

		Car car = this.carRepository.findById(id).orElseThrow();

		GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);

		return response;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {

		this.carBusinessRules.checkIfCarPlateExists(createCarRequest.getPlate());

		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);

		this.carRepository.save(car);

	}

	@Override
	public void deleteById(int id) {

		this.carRepository.deleteById(id);

	}

}
