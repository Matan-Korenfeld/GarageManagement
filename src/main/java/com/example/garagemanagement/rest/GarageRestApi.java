package com.example.garagemanagement.rest;

import com.example.garagemanagement.entities.VehicleRequestObject;
import com.example.garagemanagement.entities.vehicle.Vehicle;
import com.example.garagemanagement.logicmanager.GarageManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("garage")
public class GarageRestApi {

    /**
     * Returned vehicles are sorted by model name
     *
     * @return
     */
    @GetMapping
    public Collection<Vehicle> getAllVehiclesInGarage() {
        return GarageManager.Instance().getAllVehiclesInGarage();
    }

    /**
     * Pass in Body the following keys:
     * vehicleType: (ElectricCar,ElectricMotorcycle,RegularCar,RegularMotorcycle,Truck)
     * licenseNumber : unique number for your vehicle license plate
     * carModelName : your car model name
     *
     * @param vehicleObject
     * @return
     */
    @PostMapping("/add")
    public Vehicle addNewVehicle(@RequestBody VehicleRequestObject vehicleObject) {
        return GarageManager.Instance().addNewVehicle(vehicleObject.getVehicleType(), vehicleObject.getLicenseNumber(), vehicleObject.getCarModelName());
    }

    @GetMapping("/retrieve/{licenseNumber}")
    public Vehicle retrieveVehicle(@PathVariable String licenseNumber) {
        return GarageManager.Instance().retrieveSingleVehicle(licenseNumber);
    }

    /**
     * Returned vehicles are sorted by model name
     *
     * @return
     */
    @GetMapping("/retrieve")
    public Collection<Vehicle> retrieveVehicles() {
        return GarageManager.Instance().retrieveAllAvailableVehicles();
    }

    @PutMapping("/inflate_tires/{licenseNumber}")
    public Vehicle inflateVehicleTires(@PathVariable String licenseNumber) {
        return GarageManager.Instance().inflateVehicleTires(licenseNumber);
    }

    @PutMapping("/add_energy/{licenseNumber}")
    public Vehicle addEnergy(@PathVariable String licenseNumber) {
        return GarageManager.Instance().addEnergy(licenseNumber);
    }

    /**
     * Pass in Body the following keys:
     * licenseNumber : the license number of the vehicle you want to update the status
     * vehicleStatus : can be InTreatment or Ready
     *
     * @param statusParams
     */
    @PutMapping("/change_status")
    public Vehicle changeStatusOfVehicle(@RequestBody VehicleRequestObject statusParams) {
        return GarageManager.Instance().changeStatusOfVehicle(statusParams.getLicenseNumber(), statusParams.getVehicleStatusInString());
    }

}

