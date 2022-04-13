package com.example.garagemanagement.entities;

import lombok.Data;

@Data
public class VehicleRequestObject {

    private String vehicleType;
    private String carModelName;
    private String licenseNumber;
    private String vehicleStatusInString;

    public VehicleRequestObject() {
    }
}
