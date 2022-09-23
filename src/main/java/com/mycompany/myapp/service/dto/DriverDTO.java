package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.Car;
import java.io.Serializable;
import java.time.LocalDate;

public class DriverDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Long driveLicenseId;
    private LocalDate expirationDate;
    private LocalDate releaseDate;
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getDriveLicenseId() {
        return driveLicenseId;
    }

    public void setDriveLicenseId(Long driveLicenseId) {
        this.driveLicenseId = driveLicenseId;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
