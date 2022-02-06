package edu.escuelaing.arep;

import edu.escuelaing.arep.services.ConverterService;
import edu.escuelaing.arep.services.impl.ConverterServiceImpl;
import spark.Filter;
import spark.Request;

import static spark.Spark.*;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/1/2022
 * @project App
 */
public class App {
    private static String fahrenheitToCelciusPath = "/celsius/:fahrenheit";
    private static String celciusTofahrenheitPath = "/fahrenheit/:celsius";
    private static ConverterService cSvcimpl = new ConverterServiceImpl();

    protected static float validateInput(Request req, String param) {
        String value = req.params(param);
        boolean valid = cSvcimpl.isValidValue(value);

        if (!valid) return -1;
        return Float.parseFloat(value);
    }

    protected static void setControllers() {
        get(celciusTofahrenheitPath,"application/json" ,(req, res) -> cSvcimpl.celsiusToFahrenheit(validateInput(req, ":celsius")));
        get(fahrenheitToCelciusPath,"application/json", (req, res) -> cSvcimpl.fahrenheitToCelsius(validateInput(req, ":fahrenheit")));
    }

    public static void main(String[] args) {
        //Setting de portNumber
        port(getPort());

        //After-filters are evaluated after each request, and can read the request and read/modify the response:
        //CORS
        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        //Our API is gonna be on the base path, /api/v1
        path("/api/v1", () -> {
            //Setting the  Controllers of our API
            setControllers();
        });

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't se  (i.e. on localhost)
    }
}


