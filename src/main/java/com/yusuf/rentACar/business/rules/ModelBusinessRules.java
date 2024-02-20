package com.yusuf.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.yusuf.rentACar.core.utilites.exceptions.ModelException;
import com.yusuf.rentACar.dataAcces.abstracts.IModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

	private IModelRepository modelRepository;

	public void checkIfModelNameExists(String name) {
		if (this.modelRepository.existsByName(name)) {
			throw new ModelException("Model name already exists !!");

		}

	}

}
