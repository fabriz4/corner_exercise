package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Driver;
import com.mycompany.myapp.service.dto.DriverDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DriverMapper {
    public Driver mapDriverDTOtoDriver(DriverDTO driverDTO);

    public DriverDTO mapDriverToDriverDTO(Driver Driver);
}
