package com.mycompany.myapp.service;

import com.mycompany.myapp.config.Constants;
import com.mycompany.myapp.domain.Authority;
import com.mycompany.myapp.domain.Driver;
import com.mycompany.myapp.repository.DriverRepository;
import com.mycompany.myapp.security.AuthoritiesConstants;
import com.mycompany.myapp.security.SecurityUtils;
import com.mycompany.myapp.service.dto.DriverDTO;
import com.mycompany.myapp.service.dto.DriverFilterDTO;
import com.mycompany.myapp.service.mapper.DriverMapper;
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
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    private static final String ENTITY_NAME = "driver";

    private DriverMapper driverMapper = Mappers.getMapper(DriverMapper.class);

    public Driver createDriver(DriverDTO driverDTO) {
        if (driverDTO.getId() != null) {
            throw new BadRequestAlertException("A new driver cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Driver DriverToAdd = driverMapper.mapDriverDTOtoDriver(driverDTO);
        Driver result = driverRepository.save(DriverToAdd);

        return result;
    }

    public void deleteDriver(Long id) {
        driverRepository
            .findById(id)
            .ifPresent(driver -> {
                driverRepository.delete(driver);
            });
    }

    public Optional<Driver> retrieveDriver(Long id) {
        Optional<Driver> driver = driverRepository.findOneWithEagerRelationships(id);
        return driver;
    }

    public List<Driver> retrieveAllDrivers(boolean eagerload) {
        if (eagerload) {
            return driverRepository.findAllWithEagerRelationships();
        } else {
            return driverRepository.findAll();
        }
    }

    public Driver editDriver(DriverDTO driverDTO, Long id) {
        if (driverDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, driverDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!driverRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Driver driverToUpdate = driverMapper.mapDriverDTOtoDriver(driverDTO);

        Driver result = driverRepository.save(driverToUpdate);
        return result;
    }

    public Optional<Driver> partialEditDriver(DriverDTO driverDTO, Long id) {
        if (driverDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, driverDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!driverRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Driver> result = driverRepository
            .findById(driverDTO.getId())
            .map(existingDriver -> {
                if (driverDTO.getName() != null) {
                    existingDriver.setName(driverDTO.getName());
                }
                if (driverDTO.getSurname() != null) {
                    existingDriver.setSurname(driverDTO.getSurname());
                }
                if (driverDTO.getDriveLicenseId() != null) {
                    existingDriver.setDriveLicenseId(driverDTO.getDriveLicenseId());
                }
                if (driverDTO.getExpirationDate() != null) {
                    existingDriver.setExpirationDate(driverDTO.getExpirationDate());
                }
                if (driverDTO.getReleaseDate() != null) {
                    existingDriver.setReleaseDate(driverDTO.getReleaseDate());
                }

                return existingDriver;
            })
            .map(driverRepository::save);

        return result;
    }

    public List<Driver> retrieveDriversByCriteria(DriverFilterDTO driverFilterDTO) {
        return driverRepository.findDriverByCriteria(driverFilterDTO);
    }
}
