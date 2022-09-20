package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Car.
 */
@Entity
@Table(name = "car")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @NotNull
    @Column(name = "model", nullable = false)
    private String model;

    @NotNull
    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Min(value = 1)
    @Max(value = 9)
    @Column(name = "seat_count")
    private Integer seatCount;

    @Column(name = "convertible")
    private Boolean convertible;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "avaiable")
    private Boolean avaiable;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Car id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Car manufacturer(String manufacturer) {
        this.setManufacturer(manufacturer);
        return this;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public Car model(String model) {
        this.setModel(model);
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public Car licensePlate(String licensePlate) {
        this.setLicensePlate(licensePlate);
        return this;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getSeatCount() {
        return this.seatCount;
    }

    public Car seatCount(Integer seatCount) {
        this.setSeatCount(seatCount);
        return this;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getConvertible() {
        return this.convertible;
    }

    public Car convertible(Boolean convertible) {
        this.setConvertible(convertible);
        return this;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public Integer getRating() {
        return this.rating;
    }

    public Car rating(Integer rating) {
        this.setRating(rating);
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public Car engineType(String engineType) {
        this.setEngineType(engineType);
        return this;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Boolean getAvaiable() {
        return this.avaiable;
    }

    public Car avaiable(Boolean avaiable) {
        this.setAvaiable(avaiable);
        return this;
    }

    public void setAvaiable(Boolean avaiable) {
        this.avaiable = avaiable;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        return id != null && id.equals(((Car) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Car{" +
            "id=" + getId() +
            ", manufacturer='" + getManufacturer() + "'" +
            ", model='" + getModel() + "'" +
            ", licensePlate='" + getLicensePlate() + "'" +
            ", seatCount=" + getSeatCount() +
            ", convertible='" + getConvertible() + "'" +
            ", rating=" + getRating() +
            ", engineType='" + getEngineType() + "'" +
            ", avaiable='" + getAvaiable() + "'" +
            "}";
    }
}
