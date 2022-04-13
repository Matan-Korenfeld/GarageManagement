package com.example.garagemanagement.dao.vehicle;

import com.example.garagemanagement.dao.Tire;
import com.example.garagemanagement.dao.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehiclesFactory {

    private static final int MAX_TIRE_PRESSURE_MOTORCYCLE = 30;
    private static final int MAX_TIRE_PRESSURE_CAR = 45;
    private static final int MAX_TIRE_PRESSURE_TRUCK = 40;

    public static Vehicle createVehicle(String vehicleTypeInString, String carModelName, String licenseNumber) {
        Vehicle newVehicle = null;
        VehicleType vehicleType = VehicleType.valueOf(vehicleTypeInString);

        switch (vehicleType) {
            case Truck:
                newVehicle = createTruck(licenseNumber, carModelName);
                break;
            case RegularCar:
                newVehicle = createRegularCar(licenseNumber, carModelName);
                break;
            case ElectricCar:
                newVehicle = createElectricCar(licenseNumber, carModelName);
                break;
            case RegularMotorcycle:
                newVehicle = createRegularMotorcycle(licenseNumber, carModelName);
                break;
            case ElectricMotorcycle:
                newVehicle = createElectricMotorcycle(licenseNumber, carModelName);
                break;
        }

        return newVehicle;
    }


    private static Vehicle createRegularMotorcycle(String licenseNumber, String carModelName) {
        Vehicle newVehicle = new RegularMotorcycle();
        newVehicle.setLicenseNumber(licenseNumber);
        newVehicle.setModelName(carModelName);

        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            tires.add(new Tire(MAX_TIRE_PRESSURE_MOTORCYCLE / 2, MAX_TIRE_PRESSURE_MOTORCYCLE));
        }
        newVehicle.setTires(tires);

        return newVehicle;
    }

    private static Vehicle createElectricMotorcycle(String licenseNumber, String carModelName) {
        Vehicle newVehicle = new ElectricMotorcycle();
        newVehicle.setLicenseNumber(licenseNumber);
        newVehicle.setModelName(carModelName);

        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            tires.add(new Tire(MAX_TIRE_PRESSURE_MOTORCYCLE / 2, MAX_TIRE_PRESSURE_MOTORCYCLE));
        }
        newVehicle.setTires(tires);

        return newVehicle;
    }

    private static Vehicle createRegularCar(String licenseNumber, String carModelName) {
        Vehicle newVehicle = new RegularCar();
        newVehicle.setLicenseNumber(licenseNumber);
        newVehicle.setModelName(carModelName);

        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tires.add(new Tire(MAX_TIRE_PRESSURE_CAR / 2, MAX_TIRE_PRESSURE_CAR));
        }
        newVehicle.setTires(tires);

        return newVehicle;
    }

    private static Vehicle createElectricCar(String licenseNumber, String carModelName) {
        Vehicle newVehicle = new ElectricCar();
        newVehicle.setLicenseNumber(licenseNumber);
        newVehicle.setModelName(carModelName);

        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tires.add(new Tire(MAX_TIRE_PRESSURE_CAR / 2, MAX_TIRE_PRESSURE_CAR));
        }
        newVehicle.setTires(tires);

        return newVehicle;
    }

    private static Vehicle createTruck(String licenseNumber, String carModelName) {
        Vehicle newVehicle = new Truck();
        newVehicle.setLicenseNumber(licenseNumber);
        newVehicle.setModelName(carModelName);

        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            tires.add(new Tire(MAX_TIRE_PRESSURE_TRUCK / 2, MAX_TIRE_PRESSURE_TRUCK));
        }
        newVehicle.setTires(tires);

        return newVehicle;
    }
}
