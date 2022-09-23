package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Car;
import com.mycompany.myapp.service.dto.CarDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    public Car mapCarDTOtoCar(CarDTO carDTO);

    public CarDTO mapCarToCarDTO(Car car);
}
