package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/1/2022
 * @project App
 */
public class App {
    private static String fahrenheitToCelciusPath = "/celsius/:fahrenheit";
    private static String celciusTofahrenheitPath = "/fahrenheit/:celsius";

    protected static void setGetControllers() {
        get(celciusTofahrenheitPath, (req, res) -> {
            float celsius = Integer.parseInt(req.params(":celsius"));
            return celsiusToFahrenheit(celsius);
        });

        get(fahrenheitToCelciusPath, (req, res) -> {
            float fahrenheit = Integer.parseInt(req.params(":fahrenheit"));
            return fahrenheitToCelsius(fahrenheit);
        });
    }

    public static void main(String[] args) {
        port(getPort());
        //Setting the Get Controllers of our API
        setGetControllers();
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't se  (i.e. on localhost)
    }

    public static float celsiusToFahrenheit(float celsius) {
        return (celsius * 1.8f) + 32;
    }

    public static float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) / 1.8f;
    }
}
