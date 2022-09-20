package com.mycompany.myapp.service.dto;

import java.io.Serializable;

public class CarDTO implements Serializable {

    private static final long serialVersionUID = 11L;

    private Long id;
    private String manufacturer;
    private String model;
    private String licensePlate;
    private Boolean convertible;
    private Integer rating;
    private String engineType;
    private Boolean avaiable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
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

    public Boolean getAvaiable() {
        return avaiable;
    }

    public void setAvaiable(Boolean avaiable) {
        this.avaiable = avaiable;
    }
}
