package edu.escuelaing.arep.threads;

import edu.escuelaing.arep.services.IHttpConnectionService;
import edu.escuelaing.arep.services.impl.HttpConnectionService;

import java.io.IOException;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/8/2022
 * @project App
 */
public class ClientThread extends Thread {
    private IHttpConnectionService connectionService;

    public ClientThread() {
        this.connectionService = new HttpConnectionService();
    }

    public ClientThread(IHttpConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public void run() {
        super.run();
        try {
            connectionService.startConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
