package com.example.garagemanagement.dao.vehicle;

class ElectricCar extends Vehicle {

    public ElectricCar() {
        super();
        this.setEngine(new ElectricEngine());

    }
}
