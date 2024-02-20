package com.yusuf.rentACar.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.rentACar.entities.concretes.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer> {

	boolean existsByPlate(String plate);

}
