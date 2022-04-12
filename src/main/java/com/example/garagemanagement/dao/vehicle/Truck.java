package com.example.garagemanagement.dao.vehicle;

class Truck extends Vehicle {
    public Truck() {
        super();
        this.setEngine(new RegularEngine());
    }
}
