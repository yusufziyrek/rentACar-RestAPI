package com.yusuf.rentACar.business.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	@NotNull
	@NotBlank
	private String plate;
	
	@NotNull
	@Min(1)
	private double dailyPrice;
	
	@NotNull
	@Min(2000)
	private int modelYear;
	
	@NotNull
	@Min(1)
	private int modelId;

}
