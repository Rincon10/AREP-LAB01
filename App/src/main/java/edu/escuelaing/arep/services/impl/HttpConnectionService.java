package edu.escuelaing.arep.services.impl;

import edu.escuelaing.arep.services.IHttpConnectionService;
import org.eclipse.jetty.client.HttpConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/7/2022
 * @project App
 */
public class HttpConnectionService implements IHttpConnectionService {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String PATH = "https://calcapp-backend.herokuapp.com/api/v1/";
    private  String endPoint;
    private URL url;

    public HttpConnectionService( int number ){
        this("fahrenheit/", number);
    }

    public HttpConnectionService( String endPoint, int number){
        this.endPoint = endPoint;
        try {
            this.url = new URL(PATH+endPoint+number);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void startConnection() throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
//        System.out.println("*****************************************************************************");
//        System.out.println("GET Response Code :: " + responseCode+ "on petition" +url.getPath());

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            System.out.println("starting GET petition on " + url.getPath());
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
        System.out.println("GET DONE from url"+url.getPath()+"\n");
//        System.out.println("*****************************************************************************");
    }

    public static void main(String[] args) {
        try {
            new HttpConnectionService(4).startConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
