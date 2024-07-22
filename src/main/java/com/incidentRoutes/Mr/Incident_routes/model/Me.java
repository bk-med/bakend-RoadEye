package com.incidentRoutes.Mr.Incident_routes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Me {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationNumber;
     private String description;
    private String isInjured;
    private String hasPassenger;
    private Integer passengerCount;
    private String isPassengerInjured;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsInjured() {
        return isInjured;
    }

    public void setIsInjured(String isInjured) {
        this.isInjured = isInjured;
    }

    public String getHasPassenger() {
        return hasPassenger;
    }

    public void setHasPassenger(String hasPassenger) {
        this.hasPassenger = hasPassenger;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getIsPassengerInjured() {
        return isPassengerInjured;
    }

    public void setIsPassengerInjured(String isPassengerInjured) {
        this.isPassengerInjured = isPassengerInjured;
    }
}
