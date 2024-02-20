package com.yusuf.rentACar.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {

	ModelMapper forResponse();

	ModelMapper forRequest();

}
