package com.example.garagemanagement.dao.vehicle;

class RegularMotorcycle extends Vehicle{
    public RegularMotorcycle() {
        super();
        this.setEngine(new RegularEngine());
    }
}
