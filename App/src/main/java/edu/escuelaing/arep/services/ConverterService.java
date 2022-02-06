package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/6/2022
 * @project App
 */
public interface ConverterService {

    /**
     * Method that tries to convert the input that was sent by the user
     *
     * @param value, input value sent by the user
     * @return boolean, true if is valid false otherwise
     */
    public boolean isValidValue(String value);

    /**
     * Method that convert celcius degrees in fahrenheit
     *
     * @param celsius, celsius degrees
     * @return JsonObject, JSON that represent a response of our API
     */
    public JsonObject celsiusToFahrenheit(float celsius);

    /**
     * Method that convert  fahrenheit in degrees
     *
     * @param fahrenheit
     * @return JsonObject, JSON that represent a response of our API
     */
    public JsonObject fahrenheitToCelsius(float fahrenheit);

    /**
     * Method that transform an error exception in JSON format
     *
     * @param error, exception message
     * @return JsonObject, JSON that represent a response of our API
     */
    public JsonObject transformToError(String error);
}
