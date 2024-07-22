package com.incidentRoutes.Mr.Incident_routes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "incident_report")
public class IncidentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Embedded
    private MeFormData meFormData;

    @Embedded
    private RoadIssueData roadIssueData;

    @Embedded
    private ThirdPartiesData thirdPartiesData;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public MeFormData getMeFormData() {
        return meFormData;
    }

    public void setMeFormData(MeFormData meFormData) {
        this.meFormData = meFormData;
    }

    public RoadIssueData getRoadIssueData() {
        return roadIssueData;
    }

    public void setRoadIssueData(RoadIssueData roadIssueData) {
        this.roadIssueData = roadIssueData;
    }

    public ThirdPartiesData getThirdPartiesData() {
        return thirdPartiesData;
    }

    public void setThirdPartiesData(ThirdPartiesData thirdPartiesData) {
        this.thirdPartiesData = thirdPartiesData;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

@Embeddable
class MeFormData {
    @Column(name = "me_form_data_description")
    private String description;

    @Column(name = "me_form_data_has_passenger")
    private String hasPassenger;

    @Column(name = "me_form_data_is_injured")
    private String isInjured;

    @Column(name = "me_form_data_is_passenger_injured")
    private String isPassengerInjured;

    @Column(name = "me_form_data_passenger_count")
    private String passengerCount;

    @Column(name = "me_form_data_registration_number")
    private String registrationNumber;

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

    public String getIsPassengerInjured() {
        return isPassengerInjured;
    }

    public void setIsPassengerInjured(String isPassengerInjured) {
        this.isPassengerInjured = isPassengerInjured;
    }

    public String getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(String passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

@Embeddable
class RoadIssueData {
    @Column(name = "road_issue_data_description")
    private String description;

    @Column(name = "road_issue_data_involved")
    private String involved;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvolved() {
        return involved;
    }

    public void setInvolved(String involved) {
        this.involved = involved;
    }
}

@Embeddable
class ThirdPartiesData {
    @Column(name = "third_parties_data_description")
    private String description;

    @Column(name = "third_parties_data_driver_name")
    private String driverName;

    @Column(name = "third_parties_data_driver_number")
    private String driverNumber;

    @Column(name = "third_parties_data_involved")
    private String involved;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getInvolved() {
        return involved;
    }

    public void setInvolved(String involved) {
        this.involved = involved;
    }
}
