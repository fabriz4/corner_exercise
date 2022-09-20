package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Car;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Car entity.
 */
@SuppressWarnings("unused")
@Repository
@Component
public interface CarRepository extends JpaRepository<Car, Long> {}
