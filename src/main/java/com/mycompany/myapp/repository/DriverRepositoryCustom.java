package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Driver;
import com.mycompany.myapp.service.dto.DriverFilterDTO;
import java.util.List;

public interface DriverRepositoryCustom {
    public List<Driver> findDriverByCriteria(DriverFilterDTO driverFilterDTO);
}
