package com.example.garagemanagement.dao.vehicle;

class ElectricMotorcycle extends Vehicle{
    public ElectricMotorcycle() {
        super();
        this.setEngine(new ElectricEngine());
    }
}
