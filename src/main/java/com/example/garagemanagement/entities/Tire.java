package com.example.garagemanagement.entities;

public class Tire {

    private int currentTirePressure;
    private int maxTirePressure;

    public Tire(int currentTirePressure, int maxTirePressure) {
        setMaxTirePressure(maxTirePressure);
        setCurrentTirePressure(currentTirePressure);
    }

    public int getCurrentTirePressure() {
        return currentTirePressure;
    }

    public int getMaxTirePressure() {
        return maxTirePressure;
    }

    public void setCurrentTirePressure(int currentTirePressure) {
        if (currentTirePressure < maxTirePressure && currentTirePressure >= 0) {
            this.currentTirePressure = currentTirePressure;
        }
    }

    public void setMaxTirePressure(int maxTirePressure) {
        if (maxTirePressure >= 0) {
            this.maxTirePressure = maxTirePressure;
        }
    }

    public void inflateTire() {
        currentTirePressure = maxTirePressure;
    }
}
