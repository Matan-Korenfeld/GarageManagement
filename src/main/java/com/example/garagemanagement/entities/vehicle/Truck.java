package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleType;
import com.example.garagemanagement.entities.engines.RegularEngine;

class Truck extends Vehicle {
    public Truck() {
        super();
        this.setEngine(new RegularEngine());
    }

    public VehicleType getTypeOfVehicle() {
        return VehicleType.Truck;
    }
}
