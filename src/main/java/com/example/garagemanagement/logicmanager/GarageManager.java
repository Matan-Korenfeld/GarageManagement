package com.example.garagemanagement.logicmanager;

import com.example.garagemanagement.dao.*;
import com.example.garagemanagement.dao.vehicle.VehiclesFactory;
import com.example.garagemanagement.dao.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GarageManager {

    private static GarageManager garageManager = null;
    private HashMap<String, Vehicle> vehicleInGarage;

    private GarageManager() {
        this.vehicleInGarage = new HashMap<>();
    }

    public Collection<Vehicle> getAllVehiclesInGarage() {
        return vehicleInGarage.values().stream().sorted().toList();
    }

    public static GarageManager Instance() {
        if (garageManager == null) {
            garageManager = new GarageManager();
        }
        return garageManager;
    }

    public Vehicle addNewVehicle(String vehicleType, String licenseNumber, String carModelName) {
        Vehicle vehicleToAdd = null;

        try {
            vehicleToAdd = VehiclesFactory.createVehicle(vehicleType,carModelName,licenseNumber);
            vehicleInGarage.put(vehicleToAdd.getLicenseNumber(), vehicleToAdd);

        } catch (Exception e) {
            throw new VehicleException("Cannot create this vehicle",e);
        }

        return vehicleToAdd;
    }

    public Vehicle retrieveSingleVehicle(String licenseNumber) {
        Vehicle vehicleToRetrieve = null;

        try {
            vehicleToRetrieve = vehicleInGarage.get(licenseNumber);

            if (vehicleToRetrieve.getVehicleStatus() == VehicleStatus.Ready) {
                vehicleInGarage.remove(licenseNumber);
            }
            else {
                throw new VehicleException("This vehicle is not ready yet");
            }

        } catch (NullPointerException e) {
            throw new VehicleException("Cannot find vehicle with this license plate", e);
        }

        return vehicleToRetrieve;
    }

    public Collection<Vehicle> retrieveAllAvailableVehicles() {
        List<Vehicle> returnedVehicles = new ArrayList<>();

        for (Vehicle vehicleToRetrieve : vehicleInGarage.values()) {
            if (vehicleToRetrieve.getVehicleStatus() == VehicleStatus.Ready) {
                returnedVehicles.add(vehicleInGarage.remove(vehicleToRetrieve.getLicenseNumber()));
            }
        }

        return returnedVehicles.stream().sorted().toList();
    }

    public Vehicle inflateVehicleTires(String licenseNumber) {
        Vehicle vehicleToInflate = null;
        try {
            vehicleToInflate = vehicleInGarage.get(licenseNumber);

            for (Tire tireToInflate : vehicleToInflate.getTires()) {
                tireToInflate.inflateTire();
            }
        } catch (Exception e) {
            throw new VehicleException("Cannot find vehicle with this license plate", e);
        }

        return vehicleToInflate;
    }

    public Vehicle addEnergy(String licenseNumber) {
        Vehicle vehicleToAddEnergy = null;

        try {
            vehicleToAddEnergy = vehicleInGarage.get(licenseNumber);
            vehicleToAddEnergy.getEngine().addEnergy();

        } catch (Exception e) {
            throw new VehicleException("Cannot find vehicle with this license plate", e);
        }

        return vehicleToAddEnergy;
    }

    public Vehicle changeStatusOfVehicle(String licenseNumber, String vehicleStatusInString) {
        Vehicle vehicleToChangeStatus = null;

        try {
            VehicleStatus vehicleStatus = VehicleStatus.valueOf(vehicleStatusInString);
            vehicleToChangeStatus = vehicleInGarage.get(licenseNumber);
            vehicleToChangeStatus.setVehicleStatus(vehicleStatus);

        } catch (Exception e) {
            throw new VehicleException("Cannot change the status of this vehicle", e);
        }

        return vehicleToChangeStatus;
    }
}
