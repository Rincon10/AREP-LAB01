package edu.escuelaing.arep;

import edu.escuelaing.arep.services.ConverterService;
import edu.escuelaing.arep.services.impl.ConverterServiceImpl;
import edu.escuelaing.arep.services.impl.HttpConnectionService;
import edu.escuelaing.arep.threads.ClientThread;
import org.eclipse.jetty.http.HttpStatus;
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


    /**
     * Method that validate if the request was built successfully
     *
     * @param req,   request of user
     * @param param, param to know if convert celsius or fahrenheit
     * @return float, that represents the convertion of the number(only with a valid input)
     * @throws Exception, exception in case of an invalid input
     */
    protected static float validateInput(Request req, String param) throws Exception {
        String value = req.params(param);
        boolean valid = cSvcimpl.isValidValue(value);

        if (!valid) throw new Exception("You must enter a number");
        return Float.parseFloat(value);
    }
    //*******************************setters*********************************************

    /**
     * Method that set the instances of the multipleClients of our API
     */
    protected static void startConcurrentThreads() {
        int clients = 10;
        for (int i = 0; i < clients; i++) {
            if (i % 2 == 0) {
                new ClientThread(i).start();
            } else {
                new ClientThread(new HttpConnectionService("celsius/", i)).start();
            }
        }
    }

    /**
     * Method that set the instances of the controllers of our API
     */
    protected static void setControllers() {
        get(celciusTofahrenheitPath, "application/json", (req, res) -> cSvcimpl.celsiusToFahrenheit(validateInput(req, ":celsius")));
        get(fahrenheitToCelciusPath, "application/json", (req, res) -> cSvcimpl.fahrenheitToCelsius(validateInput(req, ":fahrenheit")));
    }

    /**
     * Main method, that start our Spark application
     */
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

            //Using Exceptions
            exception(Exception.class, (exception, request, response) -> {
                response.status(HttpStatus.BAD_REQUEST_400);
                response.body(cSvcimpl.transformToError(exception.getMessage()).toString());
            });
        });

        startConcurrentThreads();
    }

    /***
     * Method that returns the port number to use in our App
     * @return int, port number
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't se  (i.e. on localhost)
    }
}


