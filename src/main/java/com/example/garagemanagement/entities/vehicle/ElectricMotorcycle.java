package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleType;
import com.example.garagemanagement.entities.engines.ElectricEngine;

class ElectricMotorcycle extends Vehicle {
    public ElectricMotorcycle() {
        super();
        this.setEngine(new ElectricEngine());
    }

    public VehicleType getTypeOfVehicle() {
        return VehicleType.ElectricMotorcycle;
    }
}
