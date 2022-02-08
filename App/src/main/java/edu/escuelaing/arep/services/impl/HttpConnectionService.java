package edu.escuelaing.arep.services.impl;

import edu.escuelaing.arep.services.IHttpConnectionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/7/2022
 * @project App
 */
public class HttpConnectionService implements IHttpConnectionService {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://calcapp-backend.herokuapp.com/api/v1/";
    private static final String CELSIUS = "celsius/";
    private static final String FAHRENHEIT = "fahrenheit/";

    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL+CELSIUS+"4");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }

}
