package com.example.garagemanagement.dao;

public class VehicleException extends RuntimeException{

    public VehicleException(String message) {
        super(message);
    }

    public VehicleException(String message, Throwable cause) {
        super(message, cause);
    }
}
