package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/6/2022
 * @project App
 */
public interface ConverterService {


    public boolean isValidValue(String value);

    public JsonObject celsiusToFahrenheit(float celsius);

    public JsonObject fahrenheitToCelsius(float fahrenheit);

    public JsonObject transformToError(String error);
}
