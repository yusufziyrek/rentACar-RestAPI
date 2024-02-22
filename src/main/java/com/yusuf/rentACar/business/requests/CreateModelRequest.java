package com.yusuf.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

	@NotNull
	@Size(min = 2, max = 20)
	private String name;

	@NotNull
	private int brandId;

}
