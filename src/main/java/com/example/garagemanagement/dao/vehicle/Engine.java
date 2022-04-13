package com.example.garagemanagement.dao.vehicle;

public abstract class Engine {
    private double energyPercentage;

    public Engine() {
        setEnergyPercentage(50);
    }

    public void addEnergy() {
        if (energyPercentage != 100) {
            energyPercentage = 100;
        }
    }

    public double getEnergyPercentage() {
        return energyPercentage;
    }

    public void setEnergyPercentage(double energyPercentage) {
        if (energyPercentage <= 100 && this.energyPercentage < energyPercentage) {
            this.energyPercentage = energyPercentage;
        }
    }
}
