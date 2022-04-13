package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleType;
import com.example.garagemanagement.entities.engines.RegularEngine;

class RegularMotorcycle extends Vehicle {
    public RegularMotorcycle() {
        super();
        this.setEngine(new RegularEngine());
    }

    public VehicleType getTypeOfVehicle() {
        return VehicleType.RegularMotorcycle;
    }
}
