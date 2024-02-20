package com.yusuf.rentACar.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.rentACar.entities.concretes.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {

	boolean existsByName(String name);

}
