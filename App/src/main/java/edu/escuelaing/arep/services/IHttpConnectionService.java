package edu.escuelaing.arep.services;

import java.io.IOException;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/7/2022
 * @project App
 * Interface that's gonna simulate concurrent users
 */
public interface IHttpConnectionService {

    /**
     * Service that make a connection HTTP to our API
     * @throws IOException
     */
    public void startConnection() throws IOException;
}
