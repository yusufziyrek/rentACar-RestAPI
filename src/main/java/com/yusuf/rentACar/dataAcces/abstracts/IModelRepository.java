package com.yusuf.rentACar.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.rentACar.entities.concretes.Model;

@Repository
public interface IModelRepository extends JpaRepository<Model, Integer> {
	
	boolean existsByName(String name);

}
