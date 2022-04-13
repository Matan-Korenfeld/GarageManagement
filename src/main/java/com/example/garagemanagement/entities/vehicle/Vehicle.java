package com.example.garagemanagement.entities.vehicle;

import com.example.garagemanagement.entities.VehicleException;
import com.example.garagemanagement.entities.engines.Engine;
import com.example.garagemanagement.entities.Tire;
import com.example.garagemanagement.entities.VehicleStatus;

import java.util.List;
import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {

    private String modelName;
    private String LicenseNumber;
    private List<Tire> tires;
    private Engine engine;
    private VehicleStatus vehicleStatus;

    public Vehicle() {
        this.setVehicleStatus(VehicleStatus.InTreatment);
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber.length() != 9) {
            throw new VehicleException("LicenseNumber should be 9 digits");
        }
        LicenseNumber = licenseNumber;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getModelName() {
        return modelName;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(LicenseNumber, vehicle.LicenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LicenseNumber);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.modelName.compareTo(o.modelName);
    }
}
