package com.example.garagemanagement.logicmanager;

import com.example.garagemanagement.entities.VehicleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GarageAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(VehicleException.class)
    String VehicleNotFoundHandler(VehicleException vnfe) {
        return vnfe.getMessage();
    }
}
