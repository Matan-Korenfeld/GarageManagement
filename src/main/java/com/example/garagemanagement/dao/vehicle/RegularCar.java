package com.example.garagemanagement.dao.vehicle;

class RegularCar extends Vehicle {
    public RegularCar() {
        super();
        this.setEngine(new RegularEngine());
    }
}
