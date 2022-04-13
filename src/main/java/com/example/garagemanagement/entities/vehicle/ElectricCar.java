package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleType;
import com.example.garagemanagement.entities.engines.ElectricEngine;

class ElectricCar extends Vehicle {

    public ElectricCar() {
        super();
        this.setEngine(new ElectricEngine());

    }

    public VehicleType getTypeOfVehicle() {
        return VehicleType.ElectricCar;
    }
}
