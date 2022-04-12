package com.example.garagemanagement.rest;

import com.example.garagemanagement.dao.VehicleStatus;
import com.example.garagemanagement.dao.VehicleType;
import com.example.garagemanagement.dao.vehicle.Vehicle;
import com.example.garagemanagement.logicmanager.GarageManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("garage")
public class GarageRestApi {

    @GetMapping
    public Collection<Vehicle> getAllVehiclesInGarage() {
        return GarageManager.Instance().getAllVehiclesInGarage();
    }

    /**
     * Pass in Body the following keys:
     * vehicleType: (ElectricCar,ElectricMotorcycle,RegularCar,RegularMotorcycle,Truck)
     * licenseNumber : unique number for your vehicle license plate
     * carModelName : your car model name
     * @param vehicleObject
     * @return
     */
    @PostMapping ("/add")
    public Vehicle addNewVehicle(@RequestBody Map<String,String> vehicleObject) {
        return GarageManager.Instance().addNewVehicle(vehicleObject.get("vehicleType"), vehicleObject.get("licenseNumber"), vehicleObject.get("carModelName"));
    }

    @GetMapping("/retrieve/{licenseNumber}")
    public Vehicle retrieveVehicle(@PathVariable String licenseNumber) {
        return GarageManager.Instance().retrieveSingleVehicle(licenseNumber);
    }

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
     * @param statusParams
     */
    @PutMapping("/change_status")
    public void changeStatusOfVehicle(@RequestBody Map<String,String> statusParams) {
        GarageManager.Instance().changeStatusOfVehicle(statusParams.get("licenseNumber"),statusParams.get("vehicleStatus"));
    }

}

