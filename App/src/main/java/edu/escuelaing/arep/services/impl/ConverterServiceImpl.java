package edu.escuelaing.arep.services.impl;

import edu.escuelaing.arep.services.ConverterService;
import com.google.gson.JsonObject;
import org.eclipse.jetty.http.HttpStatus;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/6/2022
 * @project App
 */
public class ConverterServiceImpl implements ConverterService {
    @Override
    public boolean isValidValue(String value) {
        boolean valid;
        try {
            Float.parseFloat(value);
            valid = true;
        } catch (NumberFormatException e) {
            valid = false;
        }
        return valid;
    }

    @Override
    public JsonObject celsiusToFahrenheit(float celsius) {
        float fahrenheit = (celsius * 1.8f) + 32;
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("status_code", HttpStatus.OK_200);
        jsonObject.addProperty("value", fahrenheit);
        jsonObject.addProperty("unit", "fahrenheit");
        return jsonObject;
    }

    @Override
    public JsonObject fahrenheitToCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) / 1.8f;
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("status_code", HttpStatus.OK_200);
        jsonObject.addProperty("value", celsius);
        jsonObject.addProperty("unit", "celsius");
        return jsonObject;
    }

    @Override
    public JsonObject transformToError(String error) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("status_code", HttpStatus.BAD_REQUEST_400);
        jsonObject.addProperty("value", -1);
        jsonObject.addProperty("unit", "none");
        return jsonObject;
    }
}

