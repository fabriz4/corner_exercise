package com.mycompany.myapp.service;

import com.mycompany.myapp.config.Constants;
import com.mycompany.myapp.domain.Authority;
import com.mycompany.myapp.domain.Car;
import com.mycompany.myapp.repository.CarRepository;
import com.mycompany.myapp.security.AuthoritiesConstants;
import com.mycompany.myapp.security.SecurityUtils;
import com.mycompany.myapp.service.dto.CarDTO;
import com.mycompany.myapp.service.mapper.CarMapper;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.security.RandomUtil;

@Service
@Transactional
@Component
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static final String ENTITY_NAME = "car";

    private CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    public Car createCar(CarDTO carDTO) {
        if (carDTO.getId() != null) {
            throw new BadRequestAlertException("A new car cannot already have an ID", "car", "idexists");
        }
        Car carToAdd = carMapper.mapCarDTOtoCar(carDTO);

        return carRepository.save(carToAdd);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Optional<Car> retriveCar(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
    }

    public List<Car> retriveAllCars() {
        return carRepository.findAll();
    }

    public Car editCar(CarDTO carDTO, Long id) {
        if (carDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, carDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!carRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Car carToEdit = carMapper.mapCarDTOtoCar(carDTO);
        return carRepository.save(carToEdit);
    }
}
