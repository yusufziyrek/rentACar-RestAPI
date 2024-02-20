package com.yusuf.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.core.utilites.exceptions.CarException;
import com.yusuf.rentACar.dataAcces.abstracts.ICarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {

	private ICarRepository carRepository;

	public void checkIfCarPlateExists(String plate) {
		if (this.carRepository.existsByPlate(plate)) {
			throw new CarException("Car plate already exists !!");

		}
	}
}
