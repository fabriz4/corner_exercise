package com.mycompany.myapp.service.dto;

import java.io.Serializable;

public class DriverFilterDTO {

    private String name;
    private String surname;
    private Long driveLicenseId;
    private String licensePlate;
    private Integer rating;
    private String engineType;
    private String model;
    private String manufacturer;

    public DriverFilterDTO() {}

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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (
            "DriverFilterDTO{" +
            "name='" +
            name +
            '\'' +
            ", surname='" +
            surname +
            '\'' +
            ", driveLicenseId=" +
            driveLicenseId +
            ", licensePlate='" +
            licensePlate +
            '\'' +
            ", rating=" +
            rating +
            ", engineType='" +
            engineType +
            '\'' +
            ", model='" +
            model +
            '\'' +
            ", manufacturer='" +
            manufacturer +
            '\'' +
            '}'
        );
    }
}
