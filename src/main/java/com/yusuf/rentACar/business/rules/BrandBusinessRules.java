package com.yusuf.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.core.utilites.exceptions.BrandException;
import com.yusuf.rentACar.dataAcces.abstracts.IBrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

	private IBrandRepository brandRepository;

	public void checkIfBrandNameExists(String name) {
		if (this.brandRepository.existsByName(name)) {
			throw new BrandException("Brand name already exists !!");

		}

	}

}
