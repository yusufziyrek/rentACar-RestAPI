package com.yusuf.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

	private int id;

	private String plate;

	private double dailyPrice;

	private String modelName;

	private int modelYear;

	private String brandName;

}
