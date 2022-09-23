package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Car;
import com.mycompany.myapp.domain.Driver;
import com.mycompany.myapp.service.dto.DriverFilterDTO;
import java.util.*;
import java.util.List;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Driver entity.
 */
@Repository
public class DriverRepositoryImpl implements DriverRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger log = LoggerFactory.getLogger(DriverRepositoryImpl.class);

    @Override
    public List<Driver> findDriverByCriteria(DriverFilterDTO driverFilterDTO) {
        log.debug("DriverFinterDTO: {}", driverFilterDTO.toString());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = criteriaBuilder.createQuery(Driver.class);

        Root<Driver> driver = query.from(Driver.class);
        Join<Driver, Car> joinCar = driver.join("car");
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(driverFilterDTO.getName())) {
            predicates.add(criteriaBuilder.equal(driver.get("name"), driverFilterDTO.getName()));
        }

        if (!StringUtils.isEmpty(driverFilterDTO.getSurname())) {
            predicates.add(criteriaBuilder.equal(driver.get("surname"), driverFilterDTO.getSurname()));
        }
        if (driverFilterDTO.getDriveLicenseId() != null) {
            predicates.add(criteriaBuilder.equal(driver.get("driveLicenseId"), driverFilterDTO.getDriveLicenseId()));
        }
        if (driverFilterDTO.getRating() != null) {
            predicates.add(criteriaBuilder.equal(joinCar.get("rating"), driverFilterDTO.getRating()));
        }
        if (!StringUtils.isEmpty(driverFilterDTO.getLicensePlate())) {
            predicates.add(criteriaBuilder.equal(joinCar.get("licensePlate"), driverFilterDTO.getLicensePlate()));
        }
        if (!StringUtils.isEmpty(driverFilterDTO.getEngineType())) {
            predicates.add(criteriaBuilder.equal(joinCar.get("engineType"), driverFilterDTO.getEngineType()));
        }
        if (!StringUtils.isEmpty(driverFilterDTO.getModel())) {
            predicates.add(criteriaBuilder.equal(joinCar.get("model"), driverFilterDTO.getModel()));
        }
        if (!StringUtils.isEmpty(driverFilterDTO.getManufacturer())) {
            predicates.add(criteriaBuilder.equal(joinCar.get("manufacturer"), driverFilterDTO.getManufacturer()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
