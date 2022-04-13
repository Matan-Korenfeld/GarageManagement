package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleType;
import com.example.garagemanagement.entities.engines.RegularEngine;

class RegularCar extends Vehicle {
    public RegularCar() {
        super();
        this.setEngine(new RegularEngine());
    }

    public VehicleType getTypeOfVehicle() {
        return VehicleType.RegularCar;
    }
}
